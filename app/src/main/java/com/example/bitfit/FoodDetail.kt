/*package com.example.bitfit

import android.os.Bundle
import android.widget.Button

import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "FoodDetail"

class FoodDetail : AppCompatActivity() {
    private lateinit var foodTextView: TextView
    private lateinit var calorieTextView: TextView
    private lateinit var subBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_food)

        foodTextView = findViewById(R.id.foodDetailTxt)
        calorieTextView = findViewById(R.id.calorieDetailTxt)
        subBtn = findViewById(R.id.submitFoodBtn)
        var testText = "Added " + foodTextView.text + " Calories: " + calorieTextView.text.toString()
        subBtn.setOnClickListener{
            Toast.makeText(this,testText, Toast.LENGTH_LONG).show()
        }

    }
}*/