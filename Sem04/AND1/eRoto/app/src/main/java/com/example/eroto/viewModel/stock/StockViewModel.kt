package com.example.eroto.viewModel.stock

import androidx.lifecycle.LiveData
import com.example.eroto.models.Post
import com.example.eroto.models.PostList
import com.example.eroto.models.Stock
import com.example.eroto.models.StockLiveData

interface StockViewModel {
    fun searchStockByTicker(ticker: String)
    fun getStockPosts(ticker: String): LiveData<List<Post>>
    fun getStockByTicker(): StockLiveData
}