package com.example.eroto.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.eroto.R
import com.example.eroto.models.CreditCard

class CreditCardAdapter(list: List<CreditCard>) :
    RecyclerView.Adapter<CreditCardAdapter.ViewHolder>() {

    var list: List<CreditCard> = list
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    private var lastCheckedIndex = -1
    private var lastCheckedBox: CheckBox? = null

    fun getSelectedCreditCard(): CreditCard {
        return list[lastCheckedIndex]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_card, parent, false)
        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.expiration.text = item.expiration
        holder.numberEnding.text = item.numberEnding
        Glide.with(holder.itemView.context).load(item.img).into(holder.img)

        holder.checkBox.isChecked = position == lastCheckedIndex
        holder.checkBox.setOnClickListener {
            lastCheckedBox?.isChecked = false
            lastCheckedBox = holder.checkBox
            lastCheckedIndex = holder.absoluteAdapterPosition
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var numberEnding: TextView = itemView.findViewById(R.id.recycler_card_number_ending)
        var expiration: TextView = itemView.findViewById(R.id.recycler_card_expiration)
        var img: ImageView = itemView.findViewById(R.id.recycler_card_img)
        var checkBox: CheckBox = itemView.findViewById(R.id.recycler_card_checkbox)
        var cvv: EditText = itemView.findViewById(R.id.recycler_card_cvv)
        var removeCard: ImageView = itemView.findViewById(R.id.recycler_card_remove_credit_card)
    }
}
