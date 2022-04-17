package com.example.eroto.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.eroto.R
import com.example.eroto.models.LoginUser
import com.example.eroto.models.User
import com.example.eroto.viewModel.login.UserViewModel
import com.example.eroto.viewModel.login.UserViewModelImpl

class SignupActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel

    private lateinit var userNameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var signUpButton: Button
    private lateinit var signInTextView: TextView
    private lateinit var errorMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        userViewModel = ViewModelProvider(this).get(UserViewModelImpl::class.java)

        userNameEditText = findViewById(R.id.signupUsernameEditText)
        emailEditText = findViewById(R.id.signupEmailEditText)
        passwordEditText = findViewById(R.id.signupPasswordEditText)
        signUpButton = findViewById(R.id.signupCreateAccountButton)
        signInTextView = findViewById(R.id.signInEditText)
        errorMessage = findViewById(R.id.signupErrorMessage)

        signInTextView.setOnClickListener {
            finish()
        }

        signUpButton.setOnClickListener {
            performSignUp()
        }
    }

    private fun performSignUp() {
        val userName = userNameEditText.text.toString()
        val email = emailEditText.text.toString()
        val pass = passwordEditText.text.toString()

        try {
            userViewModel.createUser(User(userName, email, pass)).observe(this) {
                userViewModel.performLogin(LoginUser(it.email, it.password))
                    .observe(this) { openMainActivity() }
            }
        } catch (e: Exception) {
            errorMessage.text = e.message
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