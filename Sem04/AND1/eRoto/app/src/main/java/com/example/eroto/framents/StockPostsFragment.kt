package com.example.eroto.framents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eroto.R
import com.example.eroto.adapters.PostsAdapter
import com.example.eroto.viewModel.stock.StockViewModel
import com.example.eroto.viewModel.stock.StockViewModelImpl

//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

class StockPostsFragment : Fragment() {
//    private var param1: String? = null
//    private var param2: String? = null

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }

    private lateinit var postRecyclerView: RecyclerView
    private lateinit var viewModel: StockViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_stock_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postRecyclerView = view.findViewById(R.id.stock_posts_recycler_view)
        viewModel = StockViewModelImpl()

        loadPosts()
    }

    private fun loadPosts() {
        val stockPosts = viewModel.getStockPosts("")
        val adapter = PostsAdapter(stockPosts.list)
        postRecyclerView.layoutManager = LinearLayoutManager(context)
        postRecyclerView.adapter = adapter
    }

    //    companion object {
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            StockPostsFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}