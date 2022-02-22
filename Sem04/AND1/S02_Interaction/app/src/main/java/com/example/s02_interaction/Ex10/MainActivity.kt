package com.example.s02_interaction.Ex10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.s02_interaction.R

class MainActivity : AppCompatActivity() {
    private lateinit var outputTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        outputTextView = findViewById(R.id.output_text)
        val findViewById = findViewById<Button>(R.id.buttonito)
        findViewById.setOnClickListener(::clickHandler)
    }

    private fun clickHandler(view: View?) {
        outputTextView.text = resources.getString(R.string.halabala)
    }
}