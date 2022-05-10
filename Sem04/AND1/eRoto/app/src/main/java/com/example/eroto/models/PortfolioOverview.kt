package com.example.eroto.models

import com.github.mikephil.charting.data.Entry

class PortfolioOverview() {
    var currency: String = ""
    var value: Double = 0.0
    var plValue: Double = 0.0
    var plPercent: Double = 0.0
    var graphData: List<Entry> = ArrayList()

    constructor(currency: String,  value: Double,  plValue: Double,  plPercent: Double,  graphData: List<Entry>) : this() {
        this.currency = currency
        this.value = value
        this.plValue = plValue
        this.plPercent = plPercent
        this.graphData = graphData
    }
}