package com.example.bitfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.bitfit.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var foodRecyclerView: RecyclerView
    private lateinit var binding: ActivityMainBinding
    private val foods = mutableListOf<DisplayFood>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.addFood)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root


        foodRecyclerView = findViewById(R.id.foodRv)
        val articleAdapter =ListAdapter(this, foods)
        foodRecyclerView.adapter = articleAdapter



        btn.setOnClickListener{
            openAddFood()
        }
    }
    fun openAddFood() {
        val intent = Intent(this, FoodDetail2::class.java)
        startActivity(intent)
    }
}