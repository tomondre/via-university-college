package com.example.eroto.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.eroto.Helper
import com.example.eroto.R
import com.example.eroto.viewModel.placeOrder.PlaceOrderViewModel
import com.example.eroto.viewModel.placeOrder.PlaceOrderViewModelImpl
import kotlinx.coroutines.channels.ticker


class PlaceOrderFragment : Fragment() {

    private lateinit var balance: EditText
    private lateinit var placeOrderViewModel: PlaceOrderViewModel
    private lateinit var image: ImageView
    private lateinit var marketInfo: TextView
    private lateinit var stockPrice: TextView
    private lateinit var stockTicker: TextView
    private lateinit var tradeOperation: TextView
    private lateinit var marketIsOpen: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buy_stock, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        placeOrderViewModel = ViewModelProvider(this).get(PlaceOrderViewModelImpl::class.java)

        bindViews(view)
        createObservers()
        createListeners()

        replaceFragment(BuyStockDetailsFragment())
    }

    private fun bindViews(view: View) {
        balance = view.findViewById(R.id.fragment_buy_stock_balance)
        image = view.findViewById(R.id.fragment_place_order_image)
        marketInfo = view.findViewById(R.id.fragment_buy_stock_market_overview)
        stockPrice = view.findViewById(R.id.frasgment_buy_stock_price)
        stockTicker = view.findViewById(R.id.fragment_stock_ticker)
        tradeOperation = view.findViewById(R.id.fragment_buy_stock_operation)
        marketIsOpen = view.findViewById(R.id.fragment_buy_stock_market_is_openned)
    }

    private fun createListeners() {

    }

    private fun createObservers() {
        placeOrderViewModel.getLoggedInUser().observe(viewLifecycleOwner) {
            balance.setText(it.balance.balance.toString())
        }
        placeOrderViewModel.getCurrentStock().observe(viewLifecycleOwner) {
            it?.let {
                stockTicker.text = it.ticker
                stockPrice.text = it.currentPrice.toString()
                marketInfo.text = Helper.parseMarketInfo(it.market.ticker, it.market.currency)
                marketIsOpen.text = Helper.parseMarketOpen(it.market.isOpen)
                Glide.with(requireView()).load(it.img).into(image)
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        var transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragment_fragment_place_order, fragment)
        transaction?.commit()
    }
}