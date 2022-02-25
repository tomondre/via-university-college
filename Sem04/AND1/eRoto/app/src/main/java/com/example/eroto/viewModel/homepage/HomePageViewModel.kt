package com.example.eroto.viewModel.homepage

import com.example.eroto.models.BigMoverList
import com.example.eroto.models.MarketList
import com.github.mikephil.charting.data.Entry

interface HomePageViewModel {
    fun getPortfolioGraphData(): ArrayList<Entry>
    fun getBigMoverGraphData(): BigMoverList
    fun getMarketsData(): MarketList
    fun getPortfolioData(): String
    fun getPortfolioValue(): String
}