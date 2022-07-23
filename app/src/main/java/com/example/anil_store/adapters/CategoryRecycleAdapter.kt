package com.example.anil_store.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.anil_store.R
import com.example.anil_store.model.Category

class CategoryRecycleAdapter(
    val context: Context, val category: List<Category>,
    val itemClick: (Category) -> Unit
) :
    RecyclerView.Adapter<CategoryRecycleAdapter.Holder>() {

    inner class Holder(itemView: View, itemClick: (Category) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val categoryImage : ImageView = itemView.findViewById(R.id.categoryImage)
        val categoryName : TextView = itemView.findViewById(R.id.categoryName)

        fun bindCategory (category: Category,context: Context){
            val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
            categoryImage.setImageResource(resourceId)
            categoryName.text = category.title
            itemView.setOnClickListener{itemClick(category)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val View = LayoutInflater.from(context).inflate(R.layout.category_listview,parent,false)
        return Holder(View, itemClick)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindCategory(category[position],context)
    }

    override fun getItemCount(): Int {
        return category.count()
    }
}