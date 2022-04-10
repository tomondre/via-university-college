package com.example.eroto.repository.creditCard

import androidx.lifecycle.LiveData
import com.example.eroto.models.CreditCard
import com.example.eroto.models.CreditCardList

interface CreditCardRepository {
    fun getSavedCreditCards(): LiveData<List<CreditCard>>
}