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
import com.example.eroto.models.User
import com.example.eroto.viewModel.login.UserViewModel
import com.example.eroto.viewModel.login.UserViewModelImpl
import java.lang.Exception

class SignupActivity : AppCompatActivity() {

    private lateinit var userNameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var signUpButton: Button
    private lateinit var signInTextView: TextView
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        userViewModel = ViewModelProvider(this).get(UserViewModelImpl::class.java)

        userNameEditText = findViewById(R.id.signupUsernameEditText)
        emailEditText = findViewById(R.id.signupEmailEditText)
        passwordEditText = findViewById(R.id.signupPasswordEditText)
        signUpButton = findViewById(R.id.signupCreateAccountButton)
        signInTextView = findViewById(R.id.signInEditText)

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
        }
    }

    private fun openMainActivity() {
        var intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        overridePendingTransition(R.anim.no_animation, R.anim.no_animation)
    }
}