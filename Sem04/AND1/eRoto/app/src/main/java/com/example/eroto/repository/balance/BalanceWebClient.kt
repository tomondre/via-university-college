package com.example.eroto.repository.balance

import com.example.eroto.Helper
import com.example.eroto.models.Balance
import com.example.eroto.models.BalanceLiveData
import com.example.eroto.models.PortfolioOverview
import com.example.eroto.repository.portfolioOverview.PortfolioOverviewWebClient
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
        balance.value?.let {
            val d = it.balance + amount
            myRef.setValue(Balance(d))
        }
    }
}