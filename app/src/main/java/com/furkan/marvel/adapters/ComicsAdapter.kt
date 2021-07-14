package com.furkan.marvel.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.furkan.marvel.R
import com.furkan.marvel.models.Character
import com.furkan.marvel.models.Comics
import com.furkan.marvel.models.ComicsItem
import com.furkan.marvel.models.Data
import com.furkan.marvel.ui.DetailActivity
import com.furkan.marvel.utils.BaseApplication
import com.furkan.marvel.utils.Globals


class ComicsAdapter(val itemList: Comics) :
    RecyclerView.Adapter<ComicsAdapter.ItemListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListViewHolder {
        return ItemListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.similar_items,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return itemList.items.size
    }


    override fun onBindViewHolder(holder: ItemListViewHolder, position: Int) {
        holder.bindItems(itemList.items[position])
    }

    class ItemListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bindItems(itemModel: ComicsItem) {
            val name = itemView.findViewById(R.id.name) as TextView

            name.text= itemModel.name
        }
    }
}