package com.example.eroto.framents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eroto.R
import com.example.eroto.adapters.PortfolioListAdapter
import com.example.eroto.factories.PortfolioItemFactory

class PortfolioFragment : Fragment() {

    private lateinit var portfolioRecycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_portfolio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        portfolioRecycler = view.findViewById(R.id.portolio_list_recycler)

        loadPortfolioData()
    }

    private fun loadPortfolioData() {
        val generate = PortfolioItemFactory.generate(10)

        var adapter = PortfolioListAdapter()
        adapter.portfolioList = generate

        portfolioRecycler.layoutManager = LinearLayoutManager(context)
        portfolioRecycler.adapter = adapter
    }

}