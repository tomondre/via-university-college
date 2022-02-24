package com.example.eroto.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eroto.R
import com.example.eroto.models.PortfolioItem

class PortfolioListAdapter : RecyclerView.Adapter<PortfolioListAdapter.ViewHolder>() {
    var portfolioList: List<PortfolioItem> = ArrayList<PortfolioItem>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.portfolio_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = portfolioList[position]
//        TODO holder.image. = item.img
        holder.fullName.text = item.fullName
        holder.plPercent.text = "${item.plPercent}%"
        holder.plValue.text = "$${item.plValue}"
        holder.valueInvested.text = "$${item.valueInvested}"
        holder.ticker.text = item.ticker
    }

    override fun getItemCount(): Int {
        return portfolioList.size
    }

    public class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.image)
        var ticker: TextView = itemView.findViewById(R.id.ticker)
        var fullName: TextView = itemView.findViewById(R.id.full_name)
        var valueInvested: TextView = itemView.findViewById(R.id.value_invested)
        var value: TextView = itemView.findViewById(R.id.value)
        var plValue: TextView = itemView.findViewById(R.id.p_l_value)
        var plPercent: TextView = itemView.findViewById(R.id.p_l_percent)
    }
}