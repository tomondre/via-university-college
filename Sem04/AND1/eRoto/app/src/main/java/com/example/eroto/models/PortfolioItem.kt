package com.example.eroto.models

class PortfolioItem(
    var stock: Stock,
    var valueInvested: Double,
    var numberOfShares: Double
) {
    var value = stock.currentPrice * numberOfShares
}