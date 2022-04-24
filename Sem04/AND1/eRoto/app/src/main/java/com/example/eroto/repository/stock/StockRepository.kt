package com.example.eroto.repository.stock

import com.example.eroto.models.Stock

object StockRepository {

    private var webClient = StockWebClient

    fun getStockByTicker(ticker: String): Stock {
        return webClient.getStockByTicker(ticker)
    }
}