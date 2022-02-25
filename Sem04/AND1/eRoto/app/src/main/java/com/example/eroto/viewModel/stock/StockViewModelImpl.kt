package com.example.eroto.viewModel.stock

import androidx.lifecycle.ViewModel
import com.example.eroto.models.Market
import com.example.eroto.models.Stock

class StockViewModelImpl: ViewModel(), StockViewModel {
    override fun getStockByTicker(ticker: String): Stock {
        return Stock("https://etoro-cdn.etorostatic.com/market-avatars/baba/150x150.png", "BABA", "Aliabba", 100.0, 15.1, 15.1, Market("NSDQ", "USD", true))
    }
}