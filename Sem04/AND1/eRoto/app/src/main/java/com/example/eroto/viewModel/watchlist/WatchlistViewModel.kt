package com.example.eroto.viewModel.watchlist

import com.example.eroto.models.StockListLiveData

interface WatchlistViewModel {
    fun getWatchlistStocks(): StockListLiveData
}