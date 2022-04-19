package com.example.eroto.viewModel.stock

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.eroto.models.*
import com.example.eroto.repository.post.PostRepository
import com.example.eroto.repository.stock.StockRepository

class StockViewModelImpl : ViewModel(), StockViewModel {

    private var postRepository = PostRepository()
    private var stockRepository = StockRepository()

    override fun getStockByTicker(ticker: String): Stock  {
       return stockRepository.getStockByTicker(ticker)
    }

    override fun getStockPosts(ticker: String): LiveData<List<Post>> {
        return postRepository.getStockPosts(ticker)
    }
}