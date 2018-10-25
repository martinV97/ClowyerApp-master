package com.dmd.martin.clowyer.login.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.dmd.martin.clowyer.R
import com.dmd.martin.clowyer.activities.MainActivity
import com.dmd.martin.clowyer.login.presenter.LoginPresenterImpl
import com.dmd.martin.clowyer.register.view.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView {

    private var loginPresenter = LoginPresenterImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        buttonLogin.setOnClickListener {
            if(editTextUserLogin.text.isNotEmpty() && editTextPasswordLogin.text.isNotEmpty())
                if(editTextPasswordLogin.text.length >= 5)
                    loginPresenter.signIn(editTextUserLogin.text.toString(), editTextPasswordLogin.text.toString(), this)
                else
                    Toast.makeText(this, getString(R.string.length_password), Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, getString(R.string.complete_fields), Toast.LENGTH_SHORT).show()
        }
    }

  /*  private fun validateLogin(){
        buttonLogin.setOnClickListener {
            if(editTextUserLogin.text.isNotEmpty() && editTextPasswordLogin.text.isNotEmpty()) {
                if(editTextPasswordLogin.text.length >= 5)
                    LoginRest(this, editTextUserLogin.text.toString(), editTextPasswordLogin.text.toString(), imageViewLoadImage, progressBar).execute()
                else
                    Toast.makeText(this, getString(R.string.length_password), Toast.LENGTH_SHORT).show()
            }else
                Toast.makeText(this, getString(R.string.complete_fields), Toast.LENGTH_SHORT).show()
        }
    }*/

    override fun enableInputs() {
        editTextUserLogin.isEnabled = true
        editTextPasswordLogin.isEnabled = true
        buttonLogin.isEnabled = true
    }

    override fun disableInputs() {
        editTextUserLogin.isEnabled = false
        editTextPasswordLogin.isEnabled = false
        buttonLogin.isEnabled = false
    }

    override fun showProgressBar() {
        imageViewLoadImage.visibility = View.VISIBLE
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        imageViewLoadImage.visibility = View.INVISIBLE
        progressBar.visibility = View.INVISIBLE
    }

    override fun loginError(error: String) {
        Toast.makeText(this, getString(R.string.login_error) + error, Toast.LENGTH_SHORT).show()
    }

    override fun showMain() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun showRegister(){
        startActivity(Intent(this, RegisterActivity::class.java))
    }
}
