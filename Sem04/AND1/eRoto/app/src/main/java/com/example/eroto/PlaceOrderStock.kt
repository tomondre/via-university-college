package com.example.eroto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class PlaceOrderStock : AppCompatActivity() {
    private lateinit var exitButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_order_stock)

        exitButton = findViewById(R.id.exit_trade)
        exitButton.setOnClickListener(::exitActivityHandler)
    }

    private fun exitActivityHandler(view: View?) {
        finish()
    }
}