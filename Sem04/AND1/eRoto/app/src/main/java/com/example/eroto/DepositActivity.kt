package com.example.eroto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView

class DepositActivity : AppCompatActivity() {
    private lateinit var amountInput: EditText
    private lateinit var exitButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deposit)

        exitButton = findViewById(R.id.deposit_exit_button)
        amountInput = findViewById(R.id.deposit_fragment_amount_edit_text)

        exitButton.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.no_animation, R.anim.no_animation)
        }
    }
}