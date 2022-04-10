package com.example.eroto.models

import com.github.mikephil.charting.data.Entry

class PortfolioOverview(var currency: String, var value: Double, var plValue: Double, var plPercent: Double, var graphData: List<Entry>) {
}