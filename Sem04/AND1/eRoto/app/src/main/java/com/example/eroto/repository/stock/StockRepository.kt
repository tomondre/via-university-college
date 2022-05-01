package com.example.eroto.repository.stock

import com.example.eroto.models.Stock
import com.example.eroto.models.StockListLiveData
import com.example.eroto.models.StockLiveData

object StockRepository {

    private var webClient = StockWebClient

    fun searchStockByTicker(ticker: String) {
        webClient.searchStockByTicker(ticker)
    }

    fun getStockByTicker(): StockLiveData {
        return webClient.stockByTicker
    }

    fun getWatchlistStocks(): StockListLiveData {
        return webClient.stockList
    }
}