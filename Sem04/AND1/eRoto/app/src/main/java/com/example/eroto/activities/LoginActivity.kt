package com.example.eroto.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.eroto.R
import com.example.eroto.models.LoginUser
import com.example.eroto.viewModel.user.UserViewModel
import com.example.eroto.viewModel.user.UserViewModelImpl

class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: UserViewModel

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var signInButton: Button
    private lateinit var signUpText: TextView
    private lateinit var loginErrorMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProvider(this).get(UserViewModelImpl::class.java)

        bindViews()
        createObservers()
        createListeners()
    }

    private fun bindViews() {
        emailEditText = findViewById(R.id.loginEmailEditText)
        passwordEditText = findViewById(R.id.loginPasswordEditText)
        signInButton = findViewById(R.id.loginSignInButton)
        signUpText = findViewById(R.id.loginSignUpTextView)
        loginErrorMessage = findViewById(R.id.loginErrorMessage)
    }

    private fun createObservers() {
        viewModel.getLoginResponse().observe(this) {
            if (it.isSuccessful) {
                openMainActivity()
            } else {
                loginErrorMessage.text = it.exception?.message
            }
        }
    }

    private fun createListeners() {
        signInButton.setOnClickListener {
            performLogin()
        }

        signUpText.setOnClickListener {
            openSignUpActivity()
        }
    }



    private fun openSignUpActivity() {
        var intent = Intent(this, SignupActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        finish()
        startActivity(intent)
        overridePendingTransition(R.anim.no_animation, R.anim.no_animation)
    }

    private fun performLogin() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        try {
            viewModel.performLogin(LoginUser(email, password))
        } catch (e: Exception) {
            loginErrorMessage.text = e.message
        }
    }

    private fun openMainActivity() {
        var intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        finish()
        startActivity(intent)
        overridePendingTransition(R.anim.no_animation, R.anim.no_animation)
    }
}