package com.example.s09

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WorkingDayAdapter(workingWeek: WorkingWeek) :
    RecyclerView.Adapter<WorkingDayAdapter.ViewHolder>() {

    var workingWeek = workingWeek
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_day, parent, false)
        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dayByIndex = workingWeek.getDayByIndex(position)
        holder.dayShortcut.text = dayByIndex.shortcut
        holder.morningCB.isChecked = dayByIndex.morning
        holder.noonCB.isChecked = dayByIndex.noon
        holder.afternoonCB.isChecked = dayByIndex.afternoon

        holder.noonCB.setOnClickListener {
            val checked = holder.noonCB.isChecked
            dayByIndex.noon = checked
        }

        holder.morningCB.setOnClickListener {
            val checked = holder.morningCB.isChecked
            dayByIndex.morning = checked
        }

        holder.afternoonCB.setOnClickListener {
            val checked = holder.afternoonCB.isChecked
            dayByIndex.afternoon = checked
        }
    }

    override fun getItemCount(): Int {
        return workingWeek.getDaysCount()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var dayShortcut: TextView = itemView.findViewById(R.id.dayTextView)
        var morningCB: CheckBox = itemView.findViewById(R.id.morning_checkbox)
        var noonCB: CheckBox = itemView.findViewById(R.id.noonCheckbox)
        var afternoonCB: CheckBox = itemView.findViewById(R.id.afternoonChecbox)
    }
}