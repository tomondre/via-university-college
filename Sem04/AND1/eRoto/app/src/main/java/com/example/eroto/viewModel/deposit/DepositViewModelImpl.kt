package com.example.eroto.viewModel.deposit

import android.os.CountDownTimer
import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eroto.models.CreditCard
import com.example.eroto.models.CreditCardList
import com.example.eroto.repository.creditCard.CreditCardRepository
import com.example.eroto.repository.creditCard.CreditCardWebClient
import kotlin.collections.ArrayList

class DepositViewModelImpl: ViewModel(), DepositViewModel {

    private var creditCardRepository: CreditCardRepository = CreditCardWebClient

    override fun getSavedCreditCards(): LiveData<List<CreditCard>> {
        return creditCardRepository.getSavedCreditCards()
    }
}