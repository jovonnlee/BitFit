package com.example.bitfit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

private const val TAG = "FoodDetail"

class FoodDetail2 : AppCompatActivity() {
    private lateinit var foodTextView: TextView
    private lateinit var calorieTextView: TextView
    private lateinit var subBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_food)

        foodTextView = findViewById(R.id.foodEt)
        calorieTextView = findViewById(R.id.calorieEt)
        subBtn = findViewById(R.id.submitFoodBtn)
        var testText = "Added " + foodTextView.text + " Calories: " + calorieTextView.text.toString()
        subBtn.setOnClickListener{
            //var foodEntity = FoodEntity(0,foodTextView.text.toString(), calorieTextView.text.toString().toInt() )
            lifecycleScope.launch(IO){
                FoodUpdater.addStuff(0,foodTextView.text.toString(), calorieTextView.text.toString().toInt())
                (application as FoodApplication).db.foodDao().deleteAll()
                (application as FoodApplication).db.foodDao().insert(
                    FoodEntity(
                        id = 0,
                        food = foodTextView.text.toString(),
                        calories = calorieTextView.text.toString().toInt()
                    )
                )
            }
            val foodET = findViewById<EditText>(R.id.foodEt)
            val calET = findViewById<EditText>(R.id.calorieEt)
            foodET.text.clear()
            calET.text.clear()
            val myIntent: Intent = Intent(this@FoodDetail2, MainActivity::class.java)
            myIntent.putExtra("food", foodTextView.text.toString())
            myIntent.putExtra("calories", calorieTextView.text.toString().toInt())
            startActivity(myIntent)
        }

    }
}