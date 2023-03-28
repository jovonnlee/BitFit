package com.example.bitfit

class FoodUpdater {
    companion object {
        var foodList: MutableList<FoodEntity> = ArrayList()

        fun addStuff(id: Int, food: String, calories: Int): MutableList<FoodEntity>{
            foodList.add(0, FoodEntity(0,food,calories))

            return foodList
        }
    }
}