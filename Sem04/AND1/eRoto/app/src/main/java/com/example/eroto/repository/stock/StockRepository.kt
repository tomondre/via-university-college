package com.example.eroto.repository.stock

import com.example.eroto.models.Stock

interface StockRepository {
    fun getStockByTicker(ticker: String): Stock
}