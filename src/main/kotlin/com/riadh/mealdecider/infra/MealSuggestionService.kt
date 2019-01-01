package com.riadh.mealdecider.infra

import com.riadh.mealdecider.domain.MealSuggestion
import com.riadh.mealdecider.tools.random
import org.springframework.stereotype.Service

@Service
class MealSuggestionService(val mealSuggestionRepository: MealSuggestionRepository) {
    fun getRandomMealSuggestion(): MealSuggestion?{
        val allMeals = mealSuggestionRepository.findAll().toList()
        return allMeals.random()
    }

    fun getAllMeals(): List<MealSuggestion>{
        return mealSuggestionRepository.findAll().toList()
    }
}
