package com.example.eroto.adapters

import com.example.eroto.helpers.StockClickedListener
import com.example.eroto.models.Stock

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.eroto.R


class StockListAdapter(items: List<Stock>, var listener: StockClickedListener) :
    RecyclerView.Adapter<StockListAdapter.ViewHolder>() {

    var stockList: List<Stock> = items
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_stock, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = stockList[position]
        holder.name.text = item.fullName
        holder.ticker.text = item.ticker
        holder.price.text = item.currentPrice.toString()

        var color: Int
        var sign = ""
        if (item.plValue >= 0) {
            color = R.color.main_green
        } else {
            color = R.color.main_red
            sign = "-"
        }
        holder.plValues.setTextColor(ContextCompat.getColor(holder.itemView.context, color))
        holder.plValues.text = "${sign}${item.plValue} (${sign}${item.plPercentage}%)"

//        if (position % 2 == 1) {
//            holder.itemView.setBackgroundColor(
//                ContextCompat.getColor(
//                    holder.itemView.context,
//                    R.color.portfolio_list_even
//                )
//            )
//        }

        holder.itemView.setOnClickListener {
            listener.onCellClickListener(item)
        }

        Glide.with(holder.itemView.context).load(item.img).into(holder.image)
    }

    override fun getItemCount(): Int {
        return stockList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.recycler_stock_img)
        var ticker: TextView = itemView.findViewById(R.id.recycler_stock_ticker)
        var name: TextView = itemView.findViewById(R.id.recycler_stock_name)
        var price: TextView = itemView.findViewById(R.id.recycler_stock_price)
        var plValues: TextView = itemView.findViewById(R.id.recycler_stock_pl_values)
    }
}