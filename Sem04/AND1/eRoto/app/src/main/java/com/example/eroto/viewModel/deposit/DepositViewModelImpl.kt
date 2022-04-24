package com.example.eroto.viewModel.deposit

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.eroto.models.Balance
import com.example.eroto.models.CreditCard
import com.example.eroto.repository.balance.BalanceRepository
import com.example.eroto.repository.creditCard.CreditCardRepository

class DepositViewModelImpl: ViewModel(), DepositViewModel {

    private var creditCardRepository = CreditCardRepository
    private var balanceRepository = BalanceRepository

    override fun getSavedCreditCards(): LiveData<List<CreditCard>> {
        return creditCardRepository.getSavedCreditCards()
    }

    override fun getBalance(): LiveData<Balance> {
        return balanceRepository.getBalance()
    }

    override fun addBalance(amount: Double) {
        balanceRepository.addBalance(amount)
    }
}