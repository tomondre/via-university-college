package com.example.eroto.viewModel.deposit

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.eroto.models.CreditCard
import com.example.eroto.repository.creditCard.CreditCardRepository

class DepositViewModelImpl: ViewModel(), DepositViewModel {

    private var creditCardRepository = CreditCardRepository()

    override fun getSavedCreditCards(): LiveData<List<CreditCard>> {
        return creditCardRepository.getSavedCreditCards()
    }
}