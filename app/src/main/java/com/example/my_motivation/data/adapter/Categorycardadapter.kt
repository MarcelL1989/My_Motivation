package com.example.my_motivation.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.my_motivation.R
import com.example.my_motivation.data.model.Categorycard
import com.example.my_motivation.ui.HomeFragmentDirections
import com.squareup.picasso.Picasso

class CategoryCardAdapter(): RecyclerView.Adapter<CategoryCardAdapter.ItemViewHolder>() {
    private var dataset =listOf<Categorycard>()

    fun update(newList:List<Categorycard>) {
        dataset=newList
        notifyDataSetChanged()
    }

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var iv: ImageView = view.findViewById(R.id.motivationskategorieBild)
        var text: TextView = view.findViewById(R.id.motivationskategorieText)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        var itemLayout= LayoutInflater.from(parent.context).inflate(R.layout.item,
            parent, false)
        return ItemViewHolder(itemLayout)
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var category= dataset[position]
        Picasso.get().load(category.picture).fit().centerInside().into(holder.iv)
        holder.text.text = category.text
        holder.iv.setOnClickListener {
            holder.itemView.findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                    category.detailCardsId.random()
                )
            )
        }
    }
    override fun getItemCount(): Int {
        return dataset.size
    }
}