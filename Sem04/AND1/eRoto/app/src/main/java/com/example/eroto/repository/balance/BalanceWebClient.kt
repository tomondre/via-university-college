package com.example.eroto.repository.balance

import com.example.eroto.Helper
import com.example.eroto.models.Balance
import com.example.eroto.models.BalanceLiveData
import com.google.firebase.database.DatabaseReference

object BalanceWebClient {
    var balance: BalanceLiveData
        private set
    private var myRef: DatabaseReference =
        Helper.getLoggedInUserDatabaseReference().child("balance")

    init {
        balance = BalanceLiveData(myRef)
    }

    fun addBalance(amount: Double) {
        myRef.setValue(balance.value?.let { Balance(it.balance + amount) })
    }
}