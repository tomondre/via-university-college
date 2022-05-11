package com.example.eroto.repository.balance

import androidx.lifecycle.LiveData
import com.example.eroto.models.Balance
import com.example.eroto.models.BalanceLiveData

object BalanceRepository {
    private var balanceWebClient: BalanceWebClient = BalanceWebClient

    fun getBalance(): BalanceLiveData {
        return balanceWebClient.balance;
    }

    fun addBalance(amount: Double) {
        balanceWebClient.addBalance(amount)
    }

    fun removeBalance(amount: Double) {
        balanceWebClient.removeBalance(amount)
    }
}