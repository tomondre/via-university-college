package com.example.eroto.viewModel.homepage

import androidx.lifecycle.LiveData
import com.example.eroto.models.*
import com.github.mikephil.charting.data.Entry

interface HomePageViewModel {
    fun getBigMoverGraphData(): BigMoverList
    fun getMarketsData(): MarketDataList
    fun getPosts(): LiveData<List<Post>>
    fun getPortfolioOverview(): LiveData<PortfolioOverview>
}