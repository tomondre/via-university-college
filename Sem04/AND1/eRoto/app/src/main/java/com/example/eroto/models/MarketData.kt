package com.example.eroto.models

class MarketData() {
    var ticker = ""
    var price = 0.0
    var difference = 0.0

    constructor(ticker: String, price: Double, difference: Double) : this() {
        this.ticker = ticker
        this.price = price
        this.difference = difference
    }
}