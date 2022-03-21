package com.example.eroto.viewModel.discover

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.eroto.models.MarketData
import com.example.eroto.models.MarketDataList

interface DiscoverViewModel {
    fun getMarketsData(): LiveData<List<MarketData>>
}