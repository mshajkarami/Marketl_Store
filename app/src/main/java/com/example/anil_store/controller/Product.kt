package com.example.anil_store.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.anil_store.R
import com.example.anil_store.Utilities.EXTRA_CATEGORY
import com.example.anil_store.adapters.ProductAdapter
import com.example.anil_store.services.DataSource
import kotlinx.android.synthetic.main.activity_product.*

class Product : AppCompatActivity() {
    lateinit var adapter: ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        val CategoryName = intent.getStringExtra(EXTRA_CATEGORY)
        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        Products_textView.text = CategoryName
        val date = DataSource()
        var adapter = ProductAdapter(this,date.getProducts(categoryType))
        val layoutManager = GridLayoutManager(this, 2)
        products_listView.adapter = adapter
        products_listView.layoutManager = layoutManager
    }
}