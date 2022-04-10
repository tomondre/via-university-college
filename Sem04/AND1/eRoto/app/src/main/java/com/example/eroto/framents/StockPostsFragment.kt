package com.example.eroto.framents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eroto.R
import com.example.eroto.adapters.PostsAdapter
import com.example.eroto.viewModel.stock.StockViewModel
import com.example.eroto.viewModel.stock.StockViewModelImpl

class StockPostsFragment : Fragment() {

    private lateinit var postRecyclerView: RecyclerView
    private lateinit var viewModel: StockViewModel
    private lateinit var postsAdapter: PostsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_stock_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postRecyclerView = view.findViewById(R.id.stock_posts_recycler_view)
        viewModel = ViewModelProvider(this).get(StockViewModelImpl::class.java)
        viewModel.getStockPosts("").observe(viewLifecycleOwner){
            postsAdapter.list = it
        }
        loadPosts()
    }

    private fun loadPosts() {
        val stockPosts = viewModel.getStockPosts("")
        postsAdapter = PostsAdapter(stockPosts.value!!)
        postRecyclerView.layoutManager = LinearLayoutManager(context)
        postRecyclerView.adapter = postsAdapter
    }
}