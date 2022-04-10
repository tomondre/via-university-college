package com.example.eroto.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.eroto.R

class SignupActivity : AppCompatActivity() {

    private lateinit var userNameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var signUpButton: Button
    private lateinit var signInTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        userNameEditText = findViewById(R.id.signupUsernameEditText)
        emailEditText = findViewById(R.id.signupEmailEditText)
        passwordEditText = findViewById(R.id.signupPasswordEditText)
        signUpButton = findViewById(R.id.signupCreateAccountButton)
        signInTextView = findViewById(R.id.signInEditText)

        signInTextView.setOnClickListener{
            finish()
        }

        signUpButton.setOnClickListener {
            performSignUp()
        }

    }

    private fun performSignUp() {

    }
}