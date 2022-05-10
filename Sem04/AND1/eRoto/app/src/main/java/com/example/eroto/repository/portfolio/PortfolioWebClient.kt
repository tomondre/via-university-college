package com.example.eroto.repository.portfolio

import com.example.eroto.Helper
import com.example.eroto.models.PortfolioItem
import com.example.eroto.models.UserPortfolioLiveData
import com.example.eroto.repository.portfolioOverview.PortfolioOverviewWebClient

object PortfolioWebClient{

    var userPortfolioLiveData = UserPortfolioLiveData()
        private set

    fun closePortfolioItem(item: PortfolioItem) {
        PortfolioOverviewWebClient.removePortfolioValue(item.valueInvested)
        val updatedPortfolio = ArrayList(userPortfolioLiveData.value!!)
        updatedPortfolio.remove(item)
        Helper.getUserPortfolioReference().setValue(updatedPortfolio)
    }
}