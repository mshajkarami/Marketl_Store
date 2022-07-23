package com.example.anil_store.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.anil_store.R
import com.example.anil_store.model.Product

class ProductAdapter(val context: Context, val products: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.product_listitem, parent, false)
        return ProductHolder(view)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.bindProduct(products[position], context)
    }

    inner class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage = itemView.findViewById<ImageView>(R.id.Products_Image)
        val productName = itemView.findViewById<TextView>(R.id.Products_Text)
        val productPrice = itemView.findViewById<TextView>(R.id.Products_Price)

        fun bindProduct(product: Product, context: Context) {
            val resourceId = context.resources.getIdentifier(product.image, "drawable", context.packageName)

            productImage.setImageResource(resourceId)
            productName.text = product.title
            productPrice.text = product.price
        }
    }
}