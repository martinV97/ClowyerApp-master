package com.dmd.martin.clowyer.activities

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.dmd.martin.clowyer.R
import com.dmd.martin.clowyer.constants.Constants
import com.dmd.martin.clowyer.entity.ItemLawyer
import com.dmd.martin.clowyer.services.consumeRest.RegisterRest
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*
import java.io.FileNotFoundException
import java.io.InputStream

class RegisterActivity : AppCompatActivity() {
    private var dataImg: Intent? = null
    private var selectedImage: Uri? = null
    private var bmp: Bitmap? = null
    private var fireBaseAuth: FirebaseAuth? = null
    private var authStateListener: FirebaseAuth.AuthStateListener? = null

    override fun onStart() {
        super.onStart()
        authStateListener?.let { fireBaseAuth!!.addAuthStateListener(it) }
    }

    override fun onStop() {
        super.onStop()
        authStateListener?.let { fireBaseAuth!!.removeAuthStateListener(it) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        showToolbar(resources.getString(R.string.toolbar_title_register), true)
        selectImage()
        registerLawyer()
        fireBaseAuth = FirebaseAuth.getInstance()
        startAuthListener()
    }

    private fun startAuthListener() {
        authStateListener = FirebaseAuth.AuthStateListener {
            var fireBaseUser = fireBaseAuth!!.currentUser
            if (fireBaseUser != null)
                Log.w("PPP", "Usuario logeado")
            else
                Log.w("PPP", "Usuario no logeado")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        dataImg = data
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
                        imageViewProfileRegister.setImageBitmap(bmp)
                    }
                }
            }
        }
    }

    private fun showToolbar(title: String, upButton: Boolean){
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar!!.title = title
        supportActionBar!!.setDisplayHomeAsUpEnabled(upButton)
    }

    private fun selectImage(){
        imageViewProfileRegister.setOnClickListener{
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, getString(R.string.select_image)), Constants.PICK_IMAGE)
        }
    }

    private fun registerLawyer(){
        buttonRegisterProfile.setOnClickListener {
            createAccount()
            //RegisterRest(this, createItemLawyer(), dataImg, imageViewLoadImageRegister, progressBarRegister).execute();
        }
    }

    private fun createAccount() {
        fireBaseAuth!!.createUserWithEmailAndPassword(mailRegister.text.toString(), passwordRegister.text.toString()).addOnCompleteListener {
                if (it.isSuccessful)
                    Toast.makeText(this, getString(R.string.create_account_succesfull), Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, getString(R.string.create_account_error), Toast.LENGTH_SHORT).show()
        }
    }

    private fun createItemLawyer(): ItemLawyer{
        var lawyer = ItemLawyer()
        lawyer.setIdentification(idRegister.text.toString())
        lawyer.setName(nameRegister.text.toString())
        lawyer.setSpeciality(specialityRegister.text.toString())
        lawyer.setPhone(phoneRegister.text.toString())
        lawyer.setEmail(mailRegister.text.toString())
        lawyer.setPassword(passwordRegister.text.toString())
        return lawyer
    }
}
