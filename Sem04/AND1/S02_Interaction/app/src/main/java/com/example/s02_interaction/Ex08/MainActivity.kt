package com.example.s02_interaction.Ex08

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.s02_interaction.R

class MainActivity : AppCompatActivity() {

    private lateinit var username: EditText
    private lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        username = findViewById(R.id.userName)
        password = findViewById(R.id.password)
        val findViewById = findViewById<Button>(R.id.loginButton)
        findViewById.setOnClickListener(::handler)
    }

    private fun handler(v: View) {
        if (username.text.toString() == "username" && password.text.toString() == "password") {
            Toast.makeText(this, "Logged in", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Access denied", Toast.LENGTH_SHORT).show()
        }
    }
}