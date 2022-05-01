package com.example.eroto.repository.market

import com.example.eroto.Helper
import com.example.eroto.models.MarketDataListLiveData

object MarketWebClient {

    private var myRef = Helper.getMarketDatabaseReference()

    var marketData = MarketDataListLiveData(myRef)
        private set
}