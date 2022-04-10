package com.example.eroto.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.eroto.R

class LoginActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var signInButton: Button
    private lateinit var signUpText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailEditText = findViewById(R.id.loginEmailEditText)
        passwordEditText = findViewById(R.id.loginPasswordEditText)
        signInButton = findViewById(R.id.loginSignInButton)
        signUpText = findViewById(R.id.loginSignUpTextView)

        signInButton.setOnClickListener {
            performLogin()
        }

        signUpText.setOnClickListener {
            openSignUpActivity()
        }



    }

    private fun openSignUpActivity() {
        var intent = Intent(this, DepositActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        overridePendingTransition(R.anim.no_animation, R.anim.no_animation)
    }

    private fun performLogin() {
        val email = emailEditText.text
        val password = passwordEditText.text

        var intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        overridePendingTransition(R.anim.no_animation, R.anim.no_animation)
    }
}