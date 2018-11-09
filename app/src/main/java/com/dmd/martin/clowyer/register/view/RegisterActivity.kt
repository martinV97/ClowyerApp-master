package com.dmd.martin.clowyer.register.view

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.dmd.martin.clowyer.R
import com.dmd.martin.clowyer.activities.MainActivity
import com.dmd.martin.clowyer.constants.Constants
import com.dmd.martin.clowyer.login.view.LoginActivity
import com.dmd.martin.clowyer.register.presenter.RegisterPresenterImpl
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*
import java.io.FileNotFoundException
import java.io.InputStream

class RegisterActivity : AppCompatActivity(), RegisterView {

    private var registerPresenter = RegisterPresenterImpl(this)

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
        registerOption()
        fireBaseAuth = FirebaseAuth.getInstance()
        //startAuthListener()
    }

    private fun startAuthListener() {
        authStateListener = FirebaseAuth.AuthStateListener {
            var fireBaseUser = fireBaseAuth!!.currentUser
            if (fireBaseUser != null)
                Toast.makeText(this, "Usuario logeado" + fireBaseUser.email, Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Usuario no logeado", Toast.LENGTH_SHORT).show()
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

    private fun registerOption(){
        buttonRegisterProfile.setOnClickListener {
            if(mailRegister.text.isNotEmpty() && passwordRegister.text.isNotEmpty())
                if(passwordRegister.text.length >= 5)
                    registerPresenter.register(mailRegister.text.toString(), passwordRegister.text.toString(), this)
                else
                    Toast.makeText(this, getString(R.string.length_password), Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, getString(R.string.complete_fields), Toast.LENGTH_SHORT).show()
            //createAccount()
            //RegisterRest(this, createItemLawyer(), dataImg, imageViewLoadImageRegister, progressBarRegister).execute();
        }
    }

  /*  private fun createAccount() {

        fireBaseAuth!!.createUserWithEmailAndPassword(mailRegister.text.toString(), passwordRegister.text.toString()).addOnCompleteListener {
                if (it.isSuccessful)
                    Toast.makeText(this, getString(R.string.create_account_succesfull), Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, getString(R.string.create_account_error), Toast.LENGTH_SHORT).show()
        }
    }*/

    /*  private fun createItemLawyer(): ItemLawyer{
        var lawyer = ItemLawyer()
        lawyer.setIdentification(idRegister.text.toString())
        lawyer.setName(nameRegister.text.toString())
        lawyer.setSpeciality(specialityRegister.text.toString())
        lawyer.setPhone(phoneRegister.text.toString())
        lawyer.setEmail(mailRegister.text.toString())
        lawyer.setPassword(passwordRegister.text.toString())
        return lawyer
    }*/

    override fun enableInputs() {
        idRegister.isEnabled = true
        nameRegister.isEnabled = true
        specialityRegister.isEnabled = true
        phoneRegister.isEnabled = true
        mailRegister.isEnabled = true
        passwordRegister.isEnabled = true
        buttonRegisterProfile.isEnabled = true
    }

    override fun disableInputs() {
        idRegister.isEnabled = false
        nameRegister.isEnabled = false
        specialityRegister.isEnabled = false
        phoneRegister.isEnabled = false
        mailRegister.isEnabled = false
        passwordRegister.isEnabled = false
        buttonRegisterProfile.isEnabled = false
    }

    override fun showProgressBar() {
        progressBarRegister.visibility = View.VISIBLE
        imageViewLoadImageRegister.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBarRegister.visibility = View.INVISIBLE
        imageViewLoadImageRegister.visibility = View.INVISIBLE
    }

    override fun registerError(error: String) {
        Toast.makeText(this, getString(R.string.register_error) + ": " + error, Toast.LENGTH_SHORT).show()
    }

    override fun showMain() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun showLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

}
