package com.example.eroto.viewModel.discover

import androidx.lifecycle.LiveData
import com.example.eroto.models.MarketData
import com.example.eroto.models.MarketDataListLiveData

interface DiscoverViewModel {
    fun getMarketsData(): MarketDataListLiveData
}