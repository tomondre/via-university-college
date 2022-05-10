package com.example.eroto.repository.portfolioOverview

import com.example.eroto.Helper
import com.example.eroto.models.GraphLiveData
import com.example.eroto.models.PortfolioOverviewLiveData

object PortfolioOverviewWebClient {
    var portfolioOverview: PortfolioOverviewLiveData = PortfolioOverviewLiveData()
    var graphData: GraphLiveData = GraphLiveData()

    private fun addEntryToGraph(value: Double) {
        val doubleValues = graphData.doubleValues
        doubleValues.add(value)
        Helper.getLoggedInUserGraphDataDatabaseReference().setValue(doubleValues)
    }

    fun addPortfolioValue(value: Double) {
        addEntryToGraph(getLatestPortfolioPrice() + value)
    }

    fun getLatestPortfolioPrice(): Double {
        val vals = graphData.doubleValues
        return vals[vals.size - 1]
    }

    fun removePortfolioValue(value: Double) {
        addEntryToGraph(getLatestPortfolioPrice() - value)
    }
}