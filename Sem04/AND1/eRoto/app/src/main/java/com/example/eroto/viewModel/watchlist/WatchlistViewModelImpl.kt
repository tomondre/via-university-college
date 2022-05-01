package com.example.eroto.viewModel.watchlist

import androidx.lifecycle.ViewModel
import com.example.eroto.models.StockListLiveData
import com.example.eroto.repository.stock.StockRepository

class WatchlistViewModelImpl: ViewModel(), WatchlistViewModel {
    private var stockRepository = StockRepository

    override fun getWatchlistStocks(): StockListLiveData {
        return stockRepository.getWatchlistStocks()
    }
}