package com.example.eroto.repository.market

import androidx.lifecycle.LiveData
import com.example.eroto.models.MarketData
import com.example.eroto.models.MarketDataListLiveData

object MarketRepository {

    private var webClient = MarketWebClient

    fun getMarketsData(): MarketDataListLiveData {
        return webClient.marketData
    }
}