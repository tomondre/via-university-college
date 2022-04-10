package com.example.eroto.framents

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.eroto.activities.PlaceOrderStock
import com.example.eroto.R
import com.example.eroto.viewModel.stock.StockViewModel
import com.example.eroto.viewModel.stock.StockViewModelImpl
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val TICKER = "ticker"

class StockFragment : Fragment() {
    private var ticker: String? = null
    private lateinit var viewModel: StockViewModel
    private lateinit var stockTicker: TextView
    private lateinit var stockImg: ImageView
    private lateinit var stockName: TextView
    private lateinit var stockPrice: TextView
    private lateinit var stockMarketStatus: TextView
    private lateinit var stockMarketOpening: TextView
    private lateinit var plText: TextView
    private lateinit var tradeButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(StockViewModelImpl::class.java)
        stockImg = view.findViewById(R.id.stock_img)
        stockTicker = view.findViewById(R.id.stock_ticker)
        stockName = view.findViewById(R.id.stock_name)
        stockPrice = view.findViewById(R.id.stock_price)
        stockMarketOpening = view.findViewById(R.id.stock_market_openning)
        stockMarketStatus = view.findViewById(R.id.stock_market_status)
        plText = view.findViewById(R.id.p_l_text)
        tradeButton = view.findViewById(R.id.trade_button)

        tradeButton.setOnClickListener {
            val intent = Intent(activity, PlaceOrderStock::class.java)
            activity?.startActivity(intent)
        }

        replaceFragment(StockPostsFragment())

        val navigation = view.findViewById<BottomNavigationView>(R.id.stock_navigation)
        navigation.setOnItemSelectedListener(::navigationHandler)

        createStockData()
    }

    private fun navigationHandler(menuItem: MenuItem): Boolean {
        var fragment: Fragment = when(menuItem.itemId) {
            R.id.chart_stock_menu_item -> StockChartFragment()
            R.id.details_stock_menu_item -> StockDetailsFragment()
            R.id.research_stock_menu_item -> StockResearchFragment()
            else -> StockPostsFragment()
        }
        replaceFragment(fragment)
        return true
    }

    private fun replaceFragment(fragment: Fragment) {
        var transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.stock_fragment_view, fragment)
        transaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            ticker = it.getString(TICKER)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_stock, container, false)
    }

    private fun createStockData() {
        Log.d("TICKER", "" + ticker)
        if (ticker == null)
            return
        val stock = viewModel.getStockByTicker(ticker!!)

        stockTicker.text = stock.ticker
        stockName.text = stock.fullName
        stockPrice.text = stock.currentPrice.toString()

        var openning = "MARKET "
        openning += if (stock.market.isOpen) "OPEN" else "CLOSED"
        stockMarketOpening.text = openning

        val status = "PRICES BY " + stock.market.ticker + ", IN " + stock.market.currency
        stockMarketStatus.text = status

        val plStatus = stock.plValue.toString() + "(" + stock.plPercentage + "%)"
        plText.text = plStatus

        Glide.with(requireActivity()).load(stock.img).into(stockImg)
    }

    companion object {
        @JvmStatic
        fun newInstance(ticker: String) =
            StockFragment().apply {
                arguments = Bundle().apply {
                    putString(TICKER, ticker)
                }
            }
    }
}