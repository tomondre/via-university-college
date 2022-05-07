package com.example.eroto.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.eroto.R
import com.example.eroto.viewModel.placeOrder.PlaceOrderViewModel
import com.example.eroto.viewModel.placeOrder.PlaceOrderViewModelImpl


class BuyStockDetailsFragment : Fragment() {

    private lateinit var buyButton: Button
    private lateinit var viewModel: PlaceOrderViewModel
    private lateinit var amount: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buy_stock_order_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(PlaceOrderViewModelImpl::class.java)
        amount = view.findViewById(R.id.fragment_buy_stock_order_details_buy_amount)
        buyButton = view.findViewById(R.id.fragment_buy_stock_order_details_buy_button)

        bindViews(view)
        createObservers()
        createListeners()
    }

    private fun bindViews(view: View) {
        buyButton = view.findViewById(R.id.fragment_buy_stock_order_details_buy_button)
    }

    private fun createObservers() {
    }

    private fun createListeners() {
        buyButton.setOnClickListener {
            val amount = amount.text.toString()
            viewModel.placeSellOrder(amount.toDouble())
        }
    }
}