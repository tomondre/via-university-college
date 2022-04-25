package com.example.eroto.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eroto.R
import com.example.eroto.adapters.CreditCardAdapter
import com.example.eroto.viewModel.deposit.DepositViewModel
import com.example.eroto.viewModel.deposit.DepositViewModelImpl

class DepositActivity : AppCompatActivity() {
    private lateinit var amountInput: EditText
    private lateinit var exitButton: ImageView
    private lateinit var viewModel: DepositViewModel
    private lateinit var creditCardRecycler: RecyclerView
    private lateinit var creditCardAdapter: CreditCardAdapter
    private lateinit var depositButton: Button
    private lateinit var currentAmount: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deposit)

        createCreditCardRecyclerView()

        bindViews()
        createListeners()
        createObservers()
    }

    private fun bindViews() {
        viewModel = ViewModelProvider(this).get(DepositViewModelImpl::class.java)
        exitButton = findViewById(R.id.deposit_exit_button)
        amountInput = findViewById(R.id.deposit_fragment_amount_edit_text)
        creditCardRecycler = findViewById(R.id.activity_deposit_recycler_credit_card)
        depositButton = findViewById(R.id.deposit_fragment_deposit_button)
        currentAmount = findViewById(R.id.deposit_fragment_current_amount)
    }

    private fun createListeners() {
        depositButton.setOnClickListener(::depositHandler)
        exitButton.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.no_animation, R.anim.no_animation)
        }
    }

    private fun createObservers() {
        viewModel.getSavedCreditCards().observe(this) {
            creditCardAdapter.list = it
        }
        viewModel.getBalance().observe(this) {
            currentAmount.setText(it.balance.toString())
        }
    }


    private fun createCreditCardRecyclerView() {
        val savedCreditCards = viewModel.getSavedCreditCards()
        creditCardAdapter = CreditCardAdapter(savedCreditCards.value!!)
        creditCardRecycler.layoutManager = LinearLayoutManager(applicationContext)
        creditCardRecycler.adapter = creditCardAdapter
    }

    private fun depositHandler(itemView: View) {
        val cc = creditCardAdapter.getSelectedCreditCard()

        var amount = amountInput.text.toString().toDouble()
        viewModel.addBalance(amount);
        Toast.makeText(
            this,
            "Depositing with credit card ending ${cc.numberEnding} and ${cc.expiration} and amount of ${amountInput.text}",
            Toast.LENGTH_LONG
        ).show()
        finish()
    }
}