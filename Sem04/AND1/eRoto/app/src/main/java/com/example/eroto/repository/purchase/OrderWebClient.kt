package com.example.eroto.repository.purchase

import com.example.eroto.Helper
import com.example.eroto.models.PortfolioItem
import com.example.eroto.repository.portfolioOverview.PortfolioOverviewWebClient
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

object OrderWebClient {


    fun placeBuyOrder(item: PortfolioItem) {
        PortfolioOverviewWebClient.addPortfolioValue(item.valueInvested)
        val ref = Helper.getUserPortfolioReference()
        ref.push().setValue(item)
    }
}