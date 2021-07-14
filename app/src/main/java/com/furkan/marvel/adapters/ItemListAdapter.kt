package com.furkan.marvel.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.furkan.marvel.R
import com.furkan.marvel.models.Character
import com.furkan.marvel.models.Data
import com.furkan.marvel.ui.DetailActivity
import com.furkan.marvel.utils.BaseApplication
import com.furkan.marvel.utils.Globals


class ItemListAdapter(val itemList: Data) :
    RecyclerView.Adapter<ItemListAdapter.ItemListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListViewHolder {
        return ItemListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_image_with_text,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return itemList.results.size
    }


    override fun onBindViewHolder(holder: ItemListViewHolder, position: Int) {
        holder.bindItems(itemList.results[position])
    }

    class ItemListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bindItems(itemModel: Character) {
            val name = itemView.findViewById(R.id.name) as TextView
            val image = itemView.findViewById(R.id.image) as ImageView
            image.setOnClickListener {
                val i = Intent(BaseApplication.getContext(), DetailActivity::class.java)
                i.putExtra("img",itemModel.thumbnail.path + "." + itemModel.thumbnail.extension)
                if (itemModel.description.isNullOrBlank())
                {
                    i.putExtra("desc","There is no information about this hero.")
                }
                else
                {
                    i.putExtra("desc",itemModel.description)
                }
                Globals.shared.Comics = itemModel.comics
                itemView.context.startActivity(i)
            }


            if (itemModel.name.isEmpty())
            {
                name.text = "There is no information about this hero."
            }
            else
            {
                name.text= itemModel.name
            }

            Glide.with(itemView)
                .load(itemModel.thumbnail.path + "." + itemModel.thumbnail.extension)
                .transform(CenterCrop(), RoundedCorners(20))
                .into(image)

        }
    }
}