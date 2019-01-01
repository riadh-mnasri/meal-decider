package com.riadh.mealdecider.infra

import com.riadh.mealdecider.domain.MealSuggestion
import com.riadh.mealdecider.tools.random
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class MealSuggestionService(val mealSuggestionRepository: MealSuggestionRepository) {
    fun getRandomMealSuggestion(): MealSuggestion?{
        val allMeals = mealSuggestionRepository.findAll().toList()
        return allMeals.random()
    }

    fun getAllMeals(): List<MealSuggestion>{
        return mealSuggestionRepository.findAll().toList()
    }

    fun getMealById(id: Int): Optional<MealSuggestion> {
        return mealSuggestionRepository.findById(id)
    }

    fun saveMeal(mealSuggestion: MealSuggestion): MealSuggestion{
        return mealSuggestionRepository.save(mealSuggestion)
    }

    fun deleteMealById(id: Int){
        return mealSuggestionRepository.deleteById(id)
    }
}
