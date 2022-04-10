package com.example.eroto.repository.post

import androidx.lifecycle.LiveData
import com.example.eroto.models.Post
import com.example.eroto.models.PostList

interface PostRepository {
    fun getStockPosts(ticker: String): LiveData<List<Post>>
}