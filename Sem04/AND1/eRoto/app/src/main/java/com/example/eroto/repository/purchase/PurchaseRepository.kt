package com.example.eroto.repository.purchase

import com.example.eroto.models.PortfolioItem
import com.example.eroto.models.User

object PurchaseRepository {
    private var purchaseWebClient = PurchaseWebClient

    fun purchaseStock(item: PortfolioItem) {
        purchaseWebClient.purchaseStock(item)
    }
}