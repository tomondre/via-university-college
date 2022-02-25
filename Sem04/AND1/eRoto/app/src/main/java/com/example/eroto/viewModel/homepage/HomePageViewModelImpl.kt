package com.example.eroto.viewModel.homepage

import androidx.lifecycle.ViewModel
import com.example.eroto.models.BigMover
import com.example.eroto.models.BigMoverList
import com.example.eroto.models.MarketData
import com.example.eroto.models.MarketDataList
import com.github.mikephil.charting.data.Entry

class HomePageViewModelImpl : ViewModel(), HomePageViewModel {
    override fun getPortfolioGraphData(): ArrayList<Entry> {
        var values = ArrayList<Entry>()
        values.add(Entry(10f, 10f))
        values.add(Entry(15f, 18f))
        values.add(Entry(30f, 15f))
        values.add(Entry(40f, 30f))
        values.add(Entry(50f, 25f))
        values.add(Entry(80f, 40f))
        values.add(Entry(100f, 30f))
        return values
    }

    override fun getBigMoverGraphData(): BigMoverList {
        var entries = ArrayList<BigMover>()
        entries.add(BigMover("AYX", "https://etoro-cdn.etorostatic.com/market-avatars/7991/150x150.png", 11.78f))
        entries.add(BigMover("CRSR", "https://etoro-cdn.etorostatic.com/market-avatars/btc/70x70.png", 9.66f))
        entries.add(BigMover("PCG", "https://etoro-cdn.etorostatic.com/market-avatars/tsla/150x150.png", 2.98f))
        entries.add(BigMover("DOYU", "https://etoro-cdn.etorostatic.com/market-avatars/aapl/150x150.png", 2.01f))
        entries.add(BigMover("BNGO", "https://etoro-cdn.etorostatic.com/market-avatars/baba/150x150.png", 1.83f))

        return BigMoverList(entries)
    }

    override fun getMarketsData(): MarketDataList {
        var markets = ArrayList<MarketData>()
        markets.add(MarketData("NSDQ100", 1222.2, 0.5))
        markets.add(MarketData("SPY50", 1222.0, 0.5))
        markets.add(MarketData("HLABAALA100", 1222.2, 0.5))
        markets.add(MarketData("HUN10", 122.2, 0.5))
        return MarketDataList(markets)
    }

    //TODO Should it be viewModel responsibility to make data suit view format? Or views?
    override fun getPortfolioData(): String {
        return "▲$488.75 (5.43%)"
    }

    override fun getPortfolioValue(): String {
        return "$9,496.21"
    }
}