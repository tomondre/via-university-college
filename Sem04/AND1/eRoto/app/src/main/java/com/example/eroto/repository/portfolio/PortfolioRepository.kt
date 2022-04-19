package com.example.eroto.repository.portfolio

import androidx.lifecycle.LiveData
import com.example.eroto.models.PortfolioItem

class PortfolioRepository {

    private var webClient = PortfolioWebClient

    fun getPortfolio(): LiveData<List<PortfolioItem>> {
        return webClient.getPortfolio()
    }
}