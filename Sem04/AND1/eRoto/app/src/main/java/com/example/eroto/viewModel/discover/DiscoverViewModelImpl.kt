package com.example.eroto.viewModel.discover

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.eroto.models.MarketData
import com.example.eroto.repository.market.MarketRepository

class DiscoverViewModelImpl : ViewModel(), DiscoverViewModel {

    private var marketRepository = MarketRepository

    override fun getMarketsData(): LiveData<List<MarketData>> {
        return marketRepository.getMarketsData()
    }
}