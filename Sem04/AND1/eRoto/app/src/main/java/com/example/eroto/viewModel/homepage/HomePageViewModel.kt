package com.example.eroto.viewModel.homepage

import androidx.lifecycle.LiveData
import com.example.eroto.models.*
import com.github.mikephil.charting.data.Entry

interface HomePageViewModel {
    fun getBigMoverGraphData(): LiveData<List<BigMover>>
    fun getMarketsData(): LiveData<List<MarketData>>
    fun getPosts(): LiveData<List<Post>>
    fun getPortfolioOverview(): LiveData<PortfolioOverview>
}