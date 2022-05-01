package com.example.eroto.viewModel.discover

import androidx.lifecycle.LiveData
import com.example.eroto.models.MarketData

interface DiscoverViewModel {
    fun getMarketsData(): LiveData<List<MarketData>>
}