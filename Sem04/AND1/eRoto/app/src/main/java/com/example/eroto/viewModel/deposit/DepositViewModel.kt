package com.example.eroto.viewModel.deposit

import androidx.lifecycle.LiveData
import com.example.eroto.models.CreditCard

interface DepositViewModel {
    fun getSavedCreditCards(): LiveData<List<CreditCard>>
}