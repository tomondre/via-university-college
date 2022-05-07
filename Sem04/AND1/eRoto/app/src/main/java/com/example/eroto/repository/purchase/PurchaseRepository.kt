package com.example.eroto.repository.purchase

import com.example.eroto.models.PortfolioItem

object PurchaseRepository {
    private var purchaseWebClient = OrderWebClient

    fun placeBuyOrder(item: PortfolioItem) {
        purchaseWebClient.placeBuyOrder(item)
    }
}