package com.example.s02_interaction.Ex07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import com.example.s02_interaction.R

class MainActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private var progressBarProgress: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        progressBar = findViewById(R.id.progressBar)
        val findViewById = findViewById<Button>(R.id.plus)
        findViewById.setOnClickListener(::handler)

        val findViewById1 = findViewById<Button>(R.id.minus)
        findViewById1.setOnClickListener(::handler)
    }

    private fun handler(v: View){
        when(v.id){
            R.id.minus -> progressBarProgress--
            R.id.plus -> progressBarProgress++
        }
        progressBar.setProgress(progressBarProgress, true)
    }
}