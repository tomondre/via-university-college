package com.example.eroto.viewModel.homepage

import androidx.lifecycle.LiveData
import com.example.eroto.models.*
import com.github.mikephil.charting.data.Entry

interface HomePageViewModel {
    fun getBigMoverGraphData(): BigMoverListLiveData
    fun getMarketsData(): MarketDataListLiveData
    fun getPosts(): LiveData<List<Post>>
    fun getPortfolioOverview(): LiveData<PortfolioOverview>
}