package com.example.eroto.repository.balance

import com.example.eroto.Helper
import com.example.eroto.models.Balance
import com.example.eroto.models.BalanceLiveData
import com.google.firebase.database.DatabaseReference

object BalanceWebClient {
    private var myRef: DatabaseReference =
        Helper.getLoggedInUserBalanceDatabaseReference()
    var balance: BalanceLiveData = BalanceLiveData(myRef)
        private set

    fun addBalance(amount: Double) {
        balance.value?.let {
            val d = it.balance + amount
            myRef.setValue(Balance(d))
        }
    }

    fun removeBalance(amount: Double) {
        balance.value?.let {
            val d = it.balance - amount
            myRef.setValue(Balance(d))
        }
    }
}