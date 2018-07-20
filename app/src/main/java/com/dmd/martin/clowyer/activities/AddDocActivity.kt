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
import com.dmd.martin.clowyer.constants.Constants
import com.google.android.gms.vision.Frame
import com.google.android.gms.vision.text.TextRecognizer
import kotlinx.android.synthetic.main.activity_add_doc.*
import java.io.FileNotFoundException
import java.io.InputStream

class AddDocActivity : AppCompatActivity() {

    private var selectedImage: Uri? = null
    private var bmp: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_doc)
        selectImage()
        recognizeText()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == Constants.PICK_IMAGE) {
            if (resultCode === Activity.RESULT_OK) {
                selectedImage = data!!.data
                val selectedPath = selectedImage!!.path
                if (requestCode === Constants.PICK_IMAGE) {
                    if (selectedPath != null) {
                        var imageStream: InputStream? = null
                        try {
                            imageStream = contentResolver.openInputStream(selectedImage)
                        } catch (e: FileNotFoundException) {
                            e.printStackTrace()
                        }
                        bmp = BitmapFactory.decodeStream(imageStream)
                        imageViewEx.setImageBitmap(bmp)
                    }
                }
            }
        }
    }

    private fun selectImage(){
        fabDocOcr.setOnClickListener{
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, getString(R.string.select_image)), Constants.PICK_IMAGE)

        }
    }

    private fun recognizeText() {
        fabDocOcrProcess.setOnClickListener{
            if (bmp == null)
                Toast.makeText(baseContext, getString(R.string.error_loaded_img), Toast.LENGTH_LONG).show()
            else{
                bmp = (imageViewEx.drawable as BitmapDrawable).bitmap
                var textRecognizer = TextRecognizer.Builder(this.applicationContext).build()
                if (!textRecognizer.isOperational)
                    Toast.makeText(baseContext, getString(R.string.ocr_error), Toast.LENGTH_LONG).show()
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
