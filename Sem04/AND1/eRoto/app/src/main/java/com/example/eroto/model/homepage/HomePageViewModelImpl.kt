package com.example.eroto.model.homepage

import androidx.lifecycle.ViewModel
import com.example.eroto.models.BigMover
import com.example.eroto.models.BigMoverList
import com.example.eroto.models.Market
import com.example.eroto.models.MarketList
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
        entries.add(BigMover("AYX", "", 11.78f))
        entries.add(BigMover("CRSR", "", 9.66f))
        entries.add(BigMover("PCG", "", 2.98f))
        entries.add(BigMover("DOYU", "", 2.01f))
        entries.add(BigMover("BNGO", "", 1.83f))

        return BigMoverList(entries)
    }

    override fun getMarketsData(): MarketList {
        var markets = ArrayList<Market>()
        markets.add(Market("NSDQ100", 1222.2, 0.5))
        markets.add(Market("SPY50", 1222.0, 0.5))
        markets.add(Market("HLABAALA100", 1222.2, 0.5))
        markets.add(Market("HUN10", 122.2, 0.5))
        return MarketList(markets)
    }

    //TODO Should it be viewModel responsibility to make data suit view format? Or views?
    override fun getPortfolioData(): String {
        return "▲$488.75 (5.43%)"
    }

    override fun getPortfolioValue(): String {
        return "$9,496.21"
    }
}