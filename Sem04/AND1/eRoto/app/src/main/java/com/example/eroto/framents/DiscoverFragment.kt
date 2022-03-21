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
import com.example.eroto.adapters.MarketAdapter
import com.example.eroto.viewModel.discover.DiscoverViewModel
import com.example.eroto.viewModel.discover.DiscoverViewModelImpl

class DiscoverFragment : Fragment() {

    private lateinit var marketRecycler: RecyclerView
    private lateinit var viewModel: DiscoverViewModel
    private lateinit var adapter: MarketAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_discover, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        marketRecycler = view.findViewById(R.id.discover_recycler_view)
        viewModel = ViewModelProvider(this).get(DiscoverViewModelImpl::class.java)

        viewModel.getMarketsData().observe(viewLifecycleOwner) {adapter.marketList = it}

        createRecyclerView()
    }

    private fun createRecyclerView() {
        val marketsData = viewModel.getMarketsData()

        adapter = MarketAdapter()
        adapter.marketList = marketsData.value!!
        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        marketRecycler.layoutManager = linearLayoutManager
        marketRecycler.adapter = adapter
    }

}