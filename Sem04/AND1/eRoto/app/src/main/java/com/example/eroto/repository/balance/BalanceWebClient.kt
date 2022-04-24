package com.example.eroto.repository.balance

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.eroto.models.Balance

object BalanceWebClient {
    private var balance = MutableLiveData<Balance>()

    init {
        loadBalance()
    }

    fun getBalance(): LiveData<Balance> {
        return balance;
    }

    fun loadBalance() {
        balance.value = Balance(200.0);
    }

    fun addBalance(amount: Double) {
        if (balance.value != null)
        {
            balance.value = Balance(balance.value!!.balance + amount)
        }
    }
}