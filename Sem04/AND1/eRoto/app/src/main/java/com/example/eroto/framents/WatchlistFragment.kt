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
import com.example.eroto.adapters.StockListAdapter
import com.example.eroto.helpers.StockClickedListener
import com.example.eroto.models.Stock
import com.example.eroto.viewModel.watchlist.WatchlistViewModel
import com.example.eroto.viewModel.watchlist.WatchlistViewModelImpl

class WatchlistFragment : Fragment(), StockClickedListener {

    private lateinit var stockRecycler: RecyclerView
    private lateinit var viewModel: WatchlistViewModel
    private lateinit var stockListAdapter: StockListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_watchlist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(WatchlistViewModelImpl::class.java)

        bindViews(view)
        createObservers()
        createListeners()

        loadStocks()
    }

    private fun bindViews(view: View) {
        stockRecycler = view.findViewById(R.id.watchlist_stock_recycler)
    }

    private fun createObservers() {
        viewModel.getWatchlistStocks().observe(viewLifecycleOwner) {
            stockListAdapter.stockList = it
        }
    }

    private fun createListeners() {

    }

    private fun loadStocks() {
        stockListAdapter = StockListAdapter(ArrayList(), this)
        stockRecycler.layoutManager = LinearLayoutManager(context)
        stockRecycler.adapter = stockListAdapter
    }

    override fun onCellClickListener(item: Stock) {
        val stockFragment = StockFragment.newInstance(item.ticker)
        val beginTransaction = activity?.supportFragmentManager?.beginTransaction()
        beginTransaction?.replace(R.id.fragmentContainerView, stockFragment)?.addToBackStack(null)
        beginTransaction?.commit()
    }
}