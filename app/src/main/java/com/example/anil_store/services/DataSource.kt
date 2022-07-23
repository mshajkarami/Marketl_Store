package com.example.anil_store.services

import com.example.anil_store.model.Category
import com.example.anil_store.model.Product

class DataSource {
    val categories = listOf(
        Category("SHIRTS", "shirtimage"),
        Category("HOODIES", "hoodieimage"),
        Category("HATS", "hatimage"),
        Category("DIGITAL", "digitalgoodsimage")
    )
    val hats = listOf(
        Product("Hat 1", "150,000", "hat1"),
        Product("Hat 2", "100,000", "hat2"),
        Product("Hat 3", "250,000", "hat3"),
        Product("Hat 4", "650,000", "hat4")
    )

    val hoodies = listOf(
        Product("Hoodie 1", "150,000", "hoodie1"),
        Product("Hoodie 2", "100,000", "hoodie2"),
        Product("Hoodie 3", "250,000", "hoodie3"),
        Product("Hoodie 4", "650,000", "hoodie4")
    )

    val shirts = listOf(
        Product("Shirts 1", "30,000", "shirt1"),
        Product("Shirts 2", "55,000", "shirt2"),
        Product("Shirts 3", "96,000", "shirt3"),
        Product("Shirts 4", "87,000", "shirt4")
    )
    val digitalGoods = listOf<Product>()

    fun getProducts(category: String?): List<Product> {
        return when (category) {
            "SHIRTS" -> shirts
            "HOODIES" -> hoodies
            "HATS" -> hats
            else -> digitalGoods
        }
    }
}