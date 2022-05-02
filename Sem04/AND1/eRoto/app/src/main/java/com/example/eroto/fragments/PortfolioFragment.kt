package com.example.eroto.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eroto.helpers.PortfolioItemClickedListener
import com.example.eroto.R
import com.example.eroto.adapters.PortfolioListAdapter
import com.example.eroto.models.PortfolioItem
import com.example.eroto.viewModel.portfolio.PortfolioViewModelImpl

class PortfolioFragment : Fragment(), PortfolioItemClickedListener {

    private lateinit var viewModel: PortfolioViewModelImpl
    private lateinit var portfolioListAdapter: PortfolioListAdapter
    private lateinit var portfolioRecycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_portfolio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(PortfolioViewModelImpl::class.java)

        bindViews(view)
        createObservers()
        createListeners()
        loadPortfolioData()
    }

    private fun bindViews(view: View) {
        portfolioRecycler = view.findViewById(R.id.portolio_list_recycler)

    }

    private fun createObservers() {
        viewModel.getPortfolio().observe(viewLifecycleOwner) {
            portfolioListAdapter.portfolioList = it
        }
    }

    private fun createListeners() {

    }

    private fun loadPortfolioData() {
        portfolioListAdapter = PortfolioListAdapter(ArrayList(), this)
        portfolioRecycler.layoutManager = LinearLayoutManager(context)
        portfolioRecycler.adapter = portfolioListAdapter
    }

    override fun onCellClickListener(item: PortfolioItem) {
        val stockFragment = StockFragment.newInstance(item.stock.ticker)
        val beginTransaction = activity?.supportFragmentManager?.beginTransaction()
        beginTransaction?.replace(R.id.fragmentContainerView, stockFragment)?.addToBackStack(null)
        beginTransaction?.commit()
    }
}