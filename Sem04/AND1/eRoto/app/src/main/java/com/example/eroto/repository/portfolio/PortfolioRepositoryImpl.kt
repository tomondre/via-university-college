package com.example.eroto.repository.portfolio

import androidx.lifecycle.LiveData
import com.example.eroto.models.PortfolioItem

class PortfolioRepositoryImpl {

    private var webClient = PortfolioWebClient

    fun getPortfolio(): LiveData<List<PortfolioItem>> {
        return webClient.getPortfolio()
    }
}