package com.example.eroto.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.eroto.R
import com.example.eroto.models.BigMover

class BigMoversAdapter : RecyclerView.Adapter<BigMoversAdapter.ViewHolder>() {

    var bigMoverList: List<BigMover> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.big_mover_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bigMover = bigMoverList[position]
        holder.ticker.text = bigMover.ticker
        Glide.with(holder.itemView.context).load(bigMover.img).into(holder.image)
    }

    override fun getItemCount(): Int {
        return bigMoverList.count()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ticker: TextView = itemView.findViewById(R.id.big_mover_ticker)
        var image: ImageView = itemView.findViewById(R.id.big_mover_img)
    }
}