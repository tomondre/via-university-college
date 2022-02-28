package com.example.eroto.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.eroto.R
import com.example.eroto.models.Notification

class NotificationAdapter(list: List<Notification>) :
    RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {

    var list: List<Notification> = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_notification, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.text.text = item.text
        holder.time.text = item.time
        var id = if (item.isRead) View.INVISIBLE else View.VISIBLE
        holder.isRead.visibility = id
        Glide.with(holder.itemView.context).load(item.img).into(holder.img)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img: ImageView = itemView.findViewById(R.id.notification_img)
        var text: TextView = itemView.findViewById(R.id.notification_text)
        var time: TextView = itemView.findViewById(R.id.notification_time)
        var isRead: TextView = itemView.findViewById(R.id.notification_is_read)
    }
}
