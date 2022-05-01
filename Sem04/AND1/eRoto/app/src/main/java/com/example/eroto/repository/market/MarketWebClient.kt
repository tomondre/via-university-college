package com.example.eroto.repository.market

import com.example.eroto.Helper
import com.example.eroto.models.MarketDataListLiveData

object MarketWebClient {

    private var myRef = Helper.getMarketDatabaseReference()

    var marketData = MarketDataListLiveData(myRef)
        private set


//    fun getMarketsData(): LiveData<List<MarketData>> {
//        var marketData = MutableLiveData<List<MarketData>>(ArrayList())
////        object : CountDownTimer(2000, 1000) {
////            override fun onTick(millisUntilFinished: Long) {}
////            override fun onFinish() {
//        var markets = ArrayList<MarketData>()
//        markets.add(MarketData("NSDQ100", 1222.2, 0.5))
//        markets.add(MarketData("SPY50", 1222.0, 0.5))
//        markets.add(MarketData("HLABAALA100", 1222.2, 0.5))
//        markets.add(MarketData("HUN10", 122.2, 0.5))
//        markets.add(MarketData("MSCW100", 122.2, 0.5))
//        markets.add(MarketData("HUN10", 122.2, 0.5))
//        marketData.value = markets
////            }
////        }.start()
//        return marketData
//    }
}