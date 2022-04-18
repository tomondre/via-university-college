package com.example.eroto.repository.market

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.eroto.models.CreditCard
import com.example.eroto.models.MarketData

object MarketWebClient {
        fun getMarketsData(): LiveData<List<MarketData>> {
        var marketData = MutableLiveData<List<MarketData>>(ArrayList())
//        object : CountDownTimer(2000, 1000) {
//            override fun onTick(millisUntilFinished: Long) {}
//            override fun onFinish() {
                var markets = ArrayList<MarketData>()
                markets.add(MarketData("NSDQ100", 1222.2, 0.5))
                markets.add(MarketData("SPY50", 1222.0, 0.5))
                markets.add(MarketData("HLABAALA100", 1222.2, 0.5))
                markets.add(MarketData("HUN10", 122.2, 0.5))
                markets.add(MarketData("MSCW100", 122.2, 0.5))
                markets.add(MarketData("HUN10", 122.2, 0.5))
                marketData.value = markets
//            }
//        }.start()
        return marketData
    }
}