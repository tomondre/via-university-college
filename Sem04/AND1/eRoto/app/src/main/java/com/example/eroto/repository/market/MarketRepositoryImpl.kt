package com.example.eroto.repository.market

import androidx.lifecycle.LiveData
import com.example.eroto.models.MarketData

class MarketRepositoryImpl {

    private var webClient = MarketWebClient

    fun getMarketsData(): LiveData<List<MarketData>> {
        return webClient.getMarketsData()
    }
}