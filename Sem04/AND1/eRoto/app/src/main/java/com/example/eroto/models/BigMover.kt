package com.example.eroto.models

class BigMover() {

    var ticker = ""
    var img = ""
    var value = 0.0f

    constructor(ticker: String, img: String, value: Float) : this() {
        this.ticker = ticker
        this.img = img
        this.value = value
    }
}