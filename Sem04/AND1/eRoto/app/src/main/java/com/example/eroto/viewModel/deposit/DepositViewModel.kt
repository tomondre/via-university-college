package com.example.eroto.viewModel.deposit

import androidx.lifecycle.LiveData
import com.example.eroto.models.Balance
import com.example.eroto.models.CreditCard
import com.example.eroto.models.CreditCardList

interface DepositViewModel {
    fun getSavedCreditCards(): LiveData<List<CreditCard>>
    fun getBalance(): LiveData<Balance>
    fun addBalance(amount: Double)
}