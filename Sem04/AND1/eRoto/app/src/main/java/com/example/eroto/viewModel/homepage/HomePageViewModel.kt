package com.example.eroto.viewModel.homepage

import com.example.eroto.models.BigMoverList
import com.example.eroto.models.MarketDataList
import com.github.mikephil.charting.data.Entry

interface HomePageViewModel {
    fun getPortfolioGraphData(): ArrayList<Entry>
    fun getBigMoverGraphData(): BigMoverList
    fun getMarketsData(): MarketDataList
    fun getPortfolioData(): String
    fun getPortfolioValue(): String
}