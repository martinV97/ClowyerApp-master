package com.dmd.martin.clowyer.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dmd.martin.clowyer.R
import com.dmd.martin.clowyer.services.consumeRest.LoginRest
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        validateLogin()
        showRegister()
    }

    private fun validateLogin(){
        buttonLogin.setOnClickListener {
            if(editTextUserLogin.text.isNotEmpty() && editTextPasswordLogin.text.isNotEmpty()) {
                if(editTextPasswordLogin.text.length >= 5)
                    LoginRest(this, editTextUserLogin.text.toString(), editTextPasswordLogin.text.toString(), imageViewLoadImage, progressBar).execute()
                else
                    Toast.makeText(this, getString(R.string.length_password), Toast.LENGTH_SHORT).show()
            }else
                Toast.makeText(this, getString(R.string.complete_fields), Toast.LENGTH_SHORT).show()
        }
    }
    private fun showRegister(){
        buttonRegister.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
