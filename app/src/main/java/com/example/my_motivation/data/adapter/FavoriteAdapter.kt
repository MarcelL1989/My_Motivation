package com.example.my_motivation.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.my_motivation.R
import com.example.my_motivation.data.model.Detailcard
import com.example.my_motivation.ui.FavoriteFragmentDirections
import com.example.my_motivation.ui.HomeFragmentDirections

class FavoriteAdapter(): RecyclerView.Adapter<FavoriteAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var text: TextView = itemView.findViewById(R.id.favourite_txt)
        var iv: ImageView = itemView.findViewById(R.id.favourite_pic)

    }
    private var dataSet= listOf<Detailcard>()
    fun submitList(newList:List<Detailcard>) {
        dataSet= newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        var listItem: View =
            LayoutInflater.from(parent.context).inflate(R.layout.favorititem, parent, false)
        return ItemViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var currentFavourite = dataSet[position]
        holder.text.text = currentFavourite.spruch
        holder.iv.load(currentFavourite.bild)
        holder.iv.setOnClickListener {
            holder.itemView.findNavController().navigate(
                FavoriteFragmentDirections.actionFavoriteFragmentToDetailFragment(currentFavourite.id)
            )

        }
    }
    override fun getItemCount(): Int {
        return dataSet.size
    }
}