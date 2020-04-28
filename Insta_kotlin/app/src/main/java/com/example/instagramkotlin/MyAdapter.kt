package com.example.instagramkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.listitem.view.*
import java.util.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MyAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<ListItem> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.listitem, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ItemViewHolder -> {
                holder.run { bind(items.get(position)) }
            }
        }
    }

    override fun getItemCount() = items.size

    fun submitList(itemList: List<ListItem>) {
        items = itemList
    }

    class ItemViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        val userImage = itemView.user_image
        val userName = itemView.user_name
        val likesNumber = itemView.likes_number

        fun bind(listItem: ListItem) {
            userName.text = listItem.username
            likesNumber.run { setText(listItem.likes) }
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(listItem.image)
                .into(userImage)
        }
    }

}