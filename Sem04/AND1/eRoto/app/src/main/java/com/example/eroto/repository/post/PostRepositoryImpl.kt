package com.example.eroto.repository.post

import androidx.lifecycle.LiveData
import com.example.eroto.models.Post

class PostRepositoryImpl {

    private var webClient = PostWebClient

    fun getStockPosts(ticker: String): LiveData<List<Post>> {
        return webClient.getStockPosts(ticker)
    }

    fun getMainPosts(): LiveData<List<Post>> {
        return webClient.getMainPosts()
    }
}