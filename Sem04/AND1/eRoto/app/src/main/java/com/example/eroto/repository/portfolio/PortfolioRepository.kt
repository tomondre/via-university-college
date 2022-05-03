package com.example.eroto.repository.portfolio

import androidx.lifecycle.LiveData
import com.example.eroto.models.PortfolioItem

object PortfolioRepository {

    private var webClient = PortfolioWebClient

    fun getPortfolio(): LiveData<List<PortfolioItem>> {
        return webClient.userPortfolioLiveData
    }
}