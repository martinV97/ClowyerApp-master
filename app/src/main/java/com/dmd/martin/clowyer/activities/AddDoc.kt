package com.dmd.martin.clowyer.activities

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dmd.martin.clowyer.R
import com.google.android.gms.vision.Frame
import com.google.android.gms.vision.text.TextRecognizer
import kotlinx.android.synthetic.main.activity_add_doc.*
import java.io.FileNotFoundException
import java.io.InputStream

class AddDoc : AppCompatActivity() {
    val PICK_IMAGE = 1
    var selectedImageUri: Uri? = null
    var selectedImage: Uri? = null

    var filePath: String? = null

    var bmp: Bitmap? = null

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == PICK_IMAGE) {
            if (resultCode === Activity.RESULT_OK) {
                selectedImage = data!!.data
                val selectedPath = selectedImage!!.path
                if (requestCode === PICK_IMAGE) {

                    if (selectedPath != null) {
                        var imageStream: InputStream? = null
                        try {
                            imageStream = contentResolver.openInputStream(
                                    selectedImage)
                        } catch (e: FileNotFoundException) {
                            e.printStackTrace()
                        }
                        // Transformamos la URI de la imagen a inputStream y este a un Bitmap
                        bmp = BitmapFactory.decodeStream(imageStream)
                        imageViewEx.setImageBitmap(bmp)
                    }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_doc)
        selectImage()
        recognizeText()
    }

    private fun selectImage(){
        fabDocOcr.setOnClickListener{
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE)

        }
    }

    private fun recognizeText() {
        fabDocOcrProcess.setOnClickListener{
            if (bmp == null)
                Toast.makeText(baseContext, "No se ha cargado ninguna imagen", Toast.LENGTH_LONG).show()
            else{
                bmp = (imageViewEx.drawable as BitmapDrawable).bitmap
                var textRecognizer = TextRecognizer.Builder(this.applicationContext).build()
                if (!textRecognizer.isOperational)
                    Toast.makeText(baseContext, "Error procesando img", Toast.LENGTH_LONG).show()
                else{
                    var frame = Frame.Builder().setBitmap(bmp).build()
                    var items = textRecognizer.detect(frame)
                    var stringBuilder = StringBuilder()
                    for (i in 0 until items.size()){
                        var textBlock = items.valueAt(i)
                        stringBuilder.append(textBlock.value)
                        stringBuilder.append("\n")
                    }
                    Toast.makeText(baseContext, stringBuilder.toString(), Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
