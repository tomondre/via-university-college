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
import com.example.eroto.viewModel.login.UserViewModel
import com.example.eroto.viewModel.login.UserViewModelImpl
import org.w3c.dom.Text
import java.lang.Exception

class LoginActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var signInButton: Button
    private lateinit var signUpText: TextView
    private lateinit var loginErrorMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailEditText = findViewById(R.id.loginEmailEditText)
        passwordEditText = findViewById(R.id.loginPasswordEditText)
        signInButton = findViewById(R.id.loginSignInButton)
        signUpText = findViewById(R.id.loginSignUpTextView)
        loginErrorMessage = findViewById(R.id.loginErrorMessage)

        signInButton.setOnClickListener {
            performLogin()
        }

        signUpText.setOnClickListener {
            openSignUpActivity()
        }

        userViewModel = ViewModelProvider(this).get(UserViewModelImpl::class.java)
    }

    private fun openSignUpActivity() {
        var intent = Intent(this, SignupActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        overridePendingTransition(R.anim.no_animation, R.anim.no_animation)
    }

    private fun performLogin() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()
        var loginUser = LoginUser(email, password)

        try {
            userViewModel.performLogin(loginUser).observe(this) {
                var intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                overridePendingTransition(R.anim.no_animation, R.anim.no_animation)
            }
        } catch (e: Exception) {
            loginErrorMessage.text = e.message
        }

    }
}