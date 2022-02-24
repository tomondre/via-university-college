package com.example.eroto.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eroto.R
import com.example.eroto.models.Market

class MarketViewAdapter : RecyclerView.Adapter<MarketViewAdapter.ViewHolder>() {

    var marketList: ArrayList<Market> = ArrayList()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.market_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.marketTicker.text = marketList[position].ticker

        holder.currentPrice.text = marketList[position].price.toString()

        var diff = marketList[position].difference
        var temp = ""
        if (diff < 0) {
            temp = "-"
        }
        holder.marketDifference.text = "$temp$diff%"
    }

    override fun getItemCount(): Int {
        return marketList.size
    }

    public class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var marketTicker: TextView = itemView.findViewById(R.id.market_ticker)
        var currentPrice: TextView = itemView.findViewById(R.id.market_current_price)
        var marketDifference: TextView = itemView.findViewById(R.id.market_difference)

    }
}