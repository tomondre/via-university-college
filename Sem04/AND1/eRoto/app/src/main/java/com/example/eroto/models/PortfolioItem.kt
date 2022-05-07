package com.example.eroto.models

class PortfolioItem() {
    var stock: Stock = Stock()
    var valueInvested: Double = 0.0
    var numberOfShares: Double = 0.0
    var value = stock.currentPrice * numberOfShares

    constructor(stock: Stock, valueInvested: Double, numberOfShares: Double) : this() {
        this.stock = stock
        this.valueInvested = valueInvested
        this.numberOfShares = numberOfShares
    }
}