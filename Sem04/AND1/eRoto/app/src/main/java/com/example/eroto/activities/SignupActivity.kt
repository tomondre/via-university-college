package com.example.eroto.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.eroto.R
import com.example.eroto.models.User
import com.example.eroto.viewModel.user.UserViewModel
import com.example.eroto.viewModel.user.UserViewModelImpl
import com.google.firebase.auth.FirebaseAuth

class SignupActivity : AppCompatActivity() {

    private lateinit var viewModel: UserViewModel

    private lateinit var userNameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var signUpButton: Button
    private lateinit var signInTextView: TextView
    private lateinit var errorMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        viewModel = ViewModelProvider(this).get(UserViewModelImpl::class.java)

        bindViews()
        createListeners()
        createObservers()
    }

    private fun bindViews() {
        userNameEditText = findViewById(R.id.signupUsernameEditText)
        emailEditText = findViewById(R.id.signupEmailEditText)
        passwordEditText = findViewById(R.id.signupPasswordEditText)
        signUpButton = findViewById(R.id.signupCreateAccountButton)
        signInTextView = findViewById(R.id.signInEditText)
        errorMessage = findViewById(R.id.signupErrorMessage)
    }

    private fun createListeners() {
        signInTextView.setOnClickListener {
            finish()
        }

        signUpButton.setOnClickListener {
            performSignUp()
        }
    }

    private fun createObservers() {
        viewModel.getSignUpResponse().observe(this) {
            if (it.isSuccessful) {
                openMainActivity()
            } else {
                errorMessage.text = it.exception?.message
            }
        }
    }

    private fun performSignUp() {
        val userName = userNameEditText.text.toString()
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        try {
            viewModel.createUser(User(userName, email, password))
        } catch (e: Exception) {
            errorMessage.text = e.message
        }
    }

    private fun openMainActivity() {
        var intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP and Intent.FLAG_ACTIVITY_CLEAR_TASK and Intent.FLAG_ACTIVITY_NEW_TASK)
        finish()
        startActivity(intent)
        overridePendingTransition(R.anim.no_animation, R.anim.no_animation)
    }
}