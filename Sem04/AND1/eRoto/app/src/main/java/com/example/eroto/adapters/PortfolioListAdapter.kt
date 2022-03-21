package com.example.eroto.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.eroto.PortfolioItemStockListener
import com.example.eroto.R
import com.example.eroto.models.PortfolioItem


class PortfolioListAdapter(items: List<PortfolioItem>, var listener: PortfolioItemStockListener) :
    RecyclerView.Adapter<PortfolioListAdapter.ViewHolder>() {

    var portfolioList: List<PortfolioItem> = items
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_portfolio_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = portfolioList[position]
        holder.fullName.text = item.stock.fullName
        holder.plPercent.text = "${item.plPercent}%"
        holder.plValue.text = "$${item.plValue}"
        holder.valueInvested.text = "$${item.valueInvested}"
        holder.ticker.text = item.stock.ticker

        if (position % 2 == 1) {
            holder.itemView.setBackgroundColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.portfolio_list_even
                )
            )
        }

        Glide.with(holder.itemView.context).load(item.stock.img).into(holder.image)
    }

    override fun getItemCount(): Int {
        return portfolioList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.image)
        var ticker: TextView = itemView.findViewById(R.id.ticker)
        var fullName: TextView = itemView.findViewById(R.id.full_name)
        var valueInvested: TextView = itemView.findViewById(R.id.value_invested)
        var value: TextView = itemView.findViewById(R.id.value)
        var plValue: TextView = itemView.findViewById(R.id.p_l_value)
        var plPercent: TextView = itemView.findViewById(R.id.p_l_percent)

        init {
            if (bindingAdapterPosition >= 0)
                listener.onCellClickListener(portfolioList[bindingAdapterPosition])
        }
    }
}