package com.example.eroto.viewModel.discover

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eroto.models.MarketData
import com.example.eroto.models.MarketDataList
import com.example.eroto.repository.market.MarketRepository
import com.example.eroto.repository.market.MarketWebClient

class DiscoverViewModelImpl : ViewModel(), DiscoverViewModel {

    private var marketRepository: MarketRepository = MarketWebClient

    override fun getMarketsData(): LiveData<List<MarketData>> {
        return marketRepository.getMarketsData()
    }
}