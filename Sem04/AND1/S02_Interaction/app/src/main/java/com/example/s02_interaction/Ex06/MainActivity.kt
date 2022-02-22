package com.example.s02_interaction.Ex06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.s02_interaction.R

class MainActivity : AppCompatActivity() {
    private lateinit var textInput: EditText
    private lateinit var textOutput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        textInput = findViewById(R.id.input)
        textOutput = findViewById(R.id.output)


        var butt: Button = findViewById(R.id.button)
        butt.setOnClickListener(::buttonHandler)
    }

    private fun buttonHandler(v: View) {
//        Toast.makeText(this, "Something is clicked", Toast.LENGTH_SHORT).show()
        val text = textInput.text
        textOutput.text = text
    }
}