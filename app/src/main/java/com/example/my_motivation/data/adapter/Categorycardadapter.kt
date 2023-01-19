package com.example.my_motivation.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.my_motivation.R
import com.example.my_motivation.data.model.Categorycard

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
        holder.iv.setImageResource(category.picture)
        holder.text.text = category.text


        //holder.iv.load(meme.url)
    }
    override fun getItemCount(): Int {
        return dataset.size
    }
}