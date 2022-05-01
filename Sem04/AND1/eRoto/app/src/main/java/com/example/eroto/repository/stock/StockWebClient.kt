package com.example.eroto.repository.stock

import com.example.eroto.Helper
import com.example.eroto.models.Market
import com.example.eroto.models.Stock
import com.example.eroto.models.StockListLiveData
import com.example.eroto.models.StockLiveData

object StockWebClient {

    private var myRef = Helper.getStocksDatabaseReference()

    var stockList = StockListLiveData(myRef)
        private set

    var stockByTicker = StockLiveData()

    fun searchStockByTicker(ticker: String) {
        val child = Helper.getStocksDatabaseReference().child(ticker)
        stockByTicker.databaseReference = child
    }
}