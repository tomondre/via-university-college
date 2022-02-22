package com.example.s02_interaction.Ex11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Switch
import com.example.s02_interaction.R

class MainActivity : AppCompatActivity() {
    private lateinit var switch: Switch
    private lateinit var image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        switch = findViewById(R.id.switcho)
        switch.setOnClickListener(::handler)
        image = findViewById(R.id.image)
    }

    private fun handler(view: View?) {
        if (switch.isChecked)
        {
            image.setImageResource(R.drawable.ic_launcher_background)
        } else {
            image.setImageResource(R.drawable.ic_launcher_foreground)
        }
    }
}