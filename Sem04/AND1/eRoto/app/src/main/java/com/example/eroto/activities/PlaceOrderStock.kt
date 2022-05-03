package com.example.eroto.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.eroto.fragments.PlaceOrderFragment
import com.example.eroto.R

class PlaceOrderStock : AppCompatActivity() {
    private lateinit var exitButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_order_stock)


        bindViews()
        createObservers()
        createListeners()
        replaceFragment(PlaceOrderFragment())
    }

    private fun bindViews() {
        exitButton = findViewById(R.id.exit_trade)

    }

    private fun replaceFragment(fragment: Fragment) {
        var transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.activity_fragment_place_order_stock_fragment, fragment)
        transaction.commit()
    }

    private fun createObservers() {
    }

    private fun createListeners() {
        exitButton.setOnClickListener(::exitActivityHandler)
    }

    private fun exitActivityHandler(view: View?) {
        finish()
    }
}