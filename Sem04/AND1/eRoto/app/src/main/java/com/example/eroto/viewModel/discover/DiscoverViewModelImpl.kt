package com.example.eroto.viewModel.discover

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eroto.models.MarketData
import com.example.eroto.models.MarketDataList

class DiscoverViewModelImpl : ViewModel(), DiscoverViewModel {

    private var marketData: MutableLiveData<List<MarketData>> = MutableLiveData()

    init {
        var markets = ArrayList<MarketData>()
        markets.add(MarketData("NSDQ100", 1222.2, 0.5))
        markets.add(MarketData("SPY50", 1222.0, 0.5))
        markets.add(MarketData("HLABAALA100", 1222.2, 0.5))
        markets.add(MarketData("HUN10", 122.2, 0.5))
        markets.add(MarketData("MSCW100", 122.2, 0.5))
        markets.add(MarketData("HUN10", 122.2, 0.5))
        marketData.value = markets
    }

    override fun getMarketsData(): LiveData<List<MarketData>> {
        return marketData
    }
}