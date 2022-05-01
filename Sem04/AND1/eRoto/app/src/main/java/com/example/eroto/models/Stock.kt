package com.example.eroto.models

class Stock() {
    lateinit var ticker: String
    lateinit var fullName: String
    var currentPrice: Double = 0.0
    var plValue: Double = 0.0
    var plPercentage: Double = 0.0
    lateinit var market: Market
    lateinit var img: String

    constructor(
        ticker: String,
        fullName: String,
        currentPrice: Double,
        plValue: Double,
        plPercentage: Double,
        market: Market,
        img: String
    ) : this() {
        this.ticker = ticker
        this.fullName = fullName
        this.currentPrice = currentPrice
        this.plValue = plValue
        this.plPercentage = plPercentage
        this.market = market
        this.img = img
    }
}