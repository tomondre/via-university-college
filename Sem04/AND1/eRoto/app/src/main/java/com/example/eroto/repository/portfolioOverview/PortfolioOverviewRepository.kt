package com.example.eroto.repository.portfolioOverview

import androidx.lifecycle.LiveData
import com.example.eroto.models.GraphLiveData
import com.example.eroto.models.PortfolioOverview

object PortfolioOverviewRepository {

    private var webClient = PortfolioOverviewWebClient

    fun getPortfolioOverview(): LiveData<PortfolioOverview> {
        return webClient.portfolioOverview
    }

    fun getGraphData(): GraphLiveData {
        return webClient.graphData
    }
}