package com.example.eroto.viewModel.deposit

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.eroto.models.CreditCard
import com.example.eroto.repository.creditCard.CreditCardRepositoryImpl

class DepositViewModelImpl: ViewModel(), DepositViewModel {

    private var creditCardRepository = CreditCardRepositoryImpl()

    override fun getSavedCreditCards(): LiveData<List<CreditCard>> {
        return creditCardRepository.getSavedCreditCards()
    }
}