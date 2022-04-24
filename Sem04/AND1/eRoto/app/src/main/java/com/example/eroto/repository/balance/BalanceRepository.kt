package com.example.eroto.repository.balance

import androidx.lifecycle.LiveData
import com.example.eroto.models.Balance

object BalanceRepository {
    private var balanceWebClient: BalanceWebClient = BalanceWebClient

    fun getBalance(): LiveData<Balance> {
        return balanceWebClient.getBalance();
    }

    fun loadBalance() {
        balanceWebClient.loadBalance()
    }

    fun addBalance(amount: Double) {
        balanceWebClient.addBalance(amount)
    }
}