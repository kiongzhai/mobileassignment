package com.example.ice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_for_items.view.*




class ItemsRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){



    private var items: List<Items> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_for_items, parent, false))
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder){
            is ItemsViewHolder ->{
                holder.bind(items.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size // tells the recycler w many items are there in the listview ho
    }

    fun submitList(item: List<Items>){
        items = item
    }

    class ItemsViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){
        val category = itemView.category
        val pic = itemView.pic
        val name = itemView.name
        val price = itemView.price

        fun bind(items: Items){
            category.setText(items.category)

            // val requestOptions = RequestOptions().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background)

            // Glide.with(itemView.context).applyDefaultRequestOptions(requestOptions).load(items.image).into(pic)
            pic.setImageResource(items.image)
            name.setText(items.name)
            price.setText(items.price.toString())
        }
    }
}