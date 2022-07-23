package com.example.anil_store.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.LayoutInflater.*
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.anil_store.R
import com.example.anil_store.model.Category

class CategoryAdapter(context: Context, category: List<Category>) : BaseAdapter() {
    val _categories = category
    val _context = context
    override fun getCount(): Int {
        return _categories.count()
    }

    override fun getItem(position: Int): Any {
        return _categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView: View
        val holder : ViewHolder
        if (convertView == null){
            holder = ViewHolder()
            categoryView= from(_context).inflate(R.layout.category_listview, null)
            holder.categoryImage = categoryView.findViewById(R.id.categoryImage)
            holder.categoryName = categoryView.findViewById(R.id.categoryName)

            categoryView.tag = holder
        }else {
            holder = convertView.tag as ViewHolder
            categoryView = convertView
        }
        val category = _categories[position]
        val resourceId =
            _context.resources.getIdentifier(category.image, "drawable", _context.packageName)
        holder.categoryName?.text = category.title
        holder.categoryImage?.setImageResource(resourceId)
        return categoryView
    }

    private class ViewHolder() {
        var categoryName: TextView? = null
        var categoryImage: ImageView? = null
    }
}