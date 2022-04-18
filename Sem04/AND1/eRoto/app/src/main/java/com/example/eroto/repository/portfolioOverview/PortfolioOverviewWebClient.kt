package com.example.eroto.repository.portfolioOverview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.eroto.models.PortfolioOverview
import com.github.mikephil.charting.data.Entry

object PortfolioOverviewWebClient {
    fun getPortfolioOverview(): LiveData<PortfolioOverview> {
        var values = ArrayList<Entry>()
        values.add(Entry(10f, 10f))
        values.add(Entry(15f, 18f))
        values.add(Entry(30f, 15f))
        values.add(Entry(40f, 30f))
        values.add(Entry(50f, 25f))
        values.add(Entry(80f, 40f))
        values.add(Entry(100f, 30f))
        var plPercentage = 5.43
        var plValue = 488.75
        var value = 9496.21
        var currency = "$"
        return MutableLiveData(PortfolioOverview(currency, value, plValue, plPercentage, values))
    }
}