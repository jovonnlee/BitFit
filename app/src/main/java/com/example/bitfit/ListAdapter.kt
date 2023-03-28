package com.example.bitfit

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

const val FOOD_EXTRA = "FOOD_EXTRA"
private const val TAG = "ListAdapter"

class ListAdapter(
    private val context: Context,
    private val foods: List<DisplayFood>)
    : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.food_detail, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food = foods[position]
        holder.bind(food)
    }


    override fun getItemCount() = foods.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val foodTextView = itemView.findViewById<TextView>(R.id.foodDetailTxt)
        private val calorieTextView = itemView.findViewById<TextView>(R.id.calorieDetailTxt)

        fun bind(food: DisplayFood) {
            foodTextView.text = food.food
            calorieTextView.text = food.calories.toString()

        }
    }
}



