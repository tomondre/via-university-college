package com.example.s02_interaction.Ex04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.s02_interaction.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var butt: Button = findViewById(R.id.button)

        butt.setOnClickListener(::buttonHandler)
    }

    private fun buttonHandler(v: View) {
        Toast.makeText(this, "Something is clicked", Toast.LENGTH_SHORT).show()
    }

}