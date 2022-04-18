package com.example.eroto.repository.creditCard

import androidx.lifecycle.LiveData
import com.example.eroto.models.CreditCard

class CreditCardRepositoryImpl {

    private var webClient = CreditCardWebClient

    fun getSavedCreditCards(): LiveData<List<CreditCard>> {
        return webClient.getSavedCreditCards()
    }
}