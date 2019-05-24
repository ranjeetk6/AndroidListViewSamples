package com.example.coderswag.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import com.example.coderswag.Adapter.CategoryAdapter
import com.example.coderswag.Adapter.CategoryRecycleAdapter
import com.example.coderswag.R
import com.example.coderswag.Services.DataService
import com.example.coderswag.Utilies.EXTRA_CATEGORY
import com.example.coderswag.model.Category
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var  adapter:CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this, DataService.categories){
            category ->  println(category.title)

            val productIntent = Intent(this, ProductActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productIntent)

        }
        categoriesListView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        categoriesListView.layoutManager = layoutManager
        categoriesListView.setHasFixedSize(true)
    }

}
