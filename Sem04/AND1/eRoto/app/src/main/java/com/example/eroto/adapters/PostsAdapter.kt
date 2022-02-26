package com.example.eroto.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.eroto.R
import com.example.eroto.models.Post

class PostsAdapter(list: List<Post>) : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {
    var list: List<Post> = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_post_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.userName.text = item.user.name
        holder.userCountry.text = item.user.country
        holder.time.text = item.time
        holder.text.text = item.text
        holder.likes.text = item.likes.toString()
        holder.comments.text = item.comments.toString()
        Glide.with(holder.itemView.context).load(item.user.image).into(holder.userImage)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var userName: TextView = itemView.findViewById(R.id.post_user_name)
        var userImage: ImageView = itemView.findViewById(R.id.post_user_image)
        var userCountry: TextView = itemView.findViewById(R.id.post_user_country)
        var time: TextView = itemView.findViewById(R.id.post_time)
        var text: TextView = itemView.findViewById(R.id.post_text)
        var likes: TextView = itemView.findViewById(R.id.post_like_count)
        var comments: TextView = itemView.findViewById(R.id.post_comment_count)
    }
}