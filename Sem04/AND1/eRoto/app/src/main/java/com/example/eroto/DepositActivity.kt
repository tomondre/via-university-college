package com.example.eroto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eroto.adapters.CreditCardAdapter
import com.example.eroto.viewModel.deposit.DepositViewModel
import com.example.eroto.viewModel.deposit.DepositViewModelImpl

class DepositActivity : AppCompatActivity() {
    private lateinit var amountInput: EditText
    private lateinit var exitButton: ImageView
    private lateinit var viewModel: DepositViewModel
    private lateinit var creditCardRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deposit)

        viewModel = ViewModelProvider(this).get(DepositViewModelImpl::class.java)
        exitButton = findViewById(R.id.deposit_exit_button)
        amountInput = findViewById(R.id.deposit_fragment_amount_edit_text)
        creditCardRecycler = findViewById(R.id.activity_deposit_recycler_credit_card)

        exitButton.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.no_animation, R.anim.no_animation)
        }

        createCreditCardRecyclerView()
    }

    private fun createCreditCardRecyclerView() {
        val savedCreditCards = viewModel.getSavedCreditCards()
        val creditCardAdapter = CreditCardAdapter(savedCreditCards.list)
        creditCardRecycler.layoutManager = LinearLayoutManager(applicationContext)
        creditCardRecycler.adapter = creditCardAdapter
    }
}