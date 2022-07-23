package com.example.anil_store.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anil_store.R
import com.example.anil_store.Utilities.EXTRA_CATEGORY
import com.example.anil_store.adapters.CategoryRecycleAdapter
import com.example.anil_store.services.DataSource
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    lateinit var adapter: CategoryRecycleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val data = DataSource()
        val adapter = CategoryRecycleAdapter(this,data.categories) {category ->
            val product = Intent(this,Product::class.java)
            product.putExtra(EXTRA_CATEGORY,category.title)
            startActivity(product)
        }
        category_listView.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        category_listView.layoutManager = layoutManager
        category_listView.setHasFixedSize(true)

    }
}