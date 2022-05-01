package com.example.eroto.models

class Market() {
    lateinit var ticker: String
    lateinit var currency: String
    var isOpen: Boolean = false

    constructor(ticker: String, currency: String, isOpen: Boolean): this() {
        this.ticker = ticker
        this.currency = currency
        this.isOpen = isOpen
    }
}