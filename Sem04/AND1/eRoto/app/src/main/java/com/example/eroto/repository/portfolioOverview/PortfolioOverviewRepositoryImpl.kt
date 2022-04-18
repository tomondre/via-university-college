package com.example.eroto.repository.portfolioOverview

import androidx.lifecycle.LiveData
import com.example.eroto.models.PortfolioOverview

class PortfolioOverviewRepositoryImpl {

    private var webClient = PortfolioOverviewWebClient

    fun getPortfolioOverview(): LiveData<PortfolioOverview> {
        return webClient.getPortfolioOverview()
    }
}