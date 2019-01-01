package com.riadh.mealdecider.infra

import com.riadh.mealdecider.domain.MealSuggestion
import org.assertj.core.api.Assertions
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito

internal class MealSuggestionServiceTest{

    @Test
    fun should_return_all_meal_suggestions(){
        // Given
        val mealSuggestionRepository = Mockito.mock(MealSuggestionRepository::class.java, Mockito.RETURNS_DEEP_STUBS)

        val mealSuggestionService = MealSuggestionService(mealSuggestionRepository)

        // When
        mealSuggestionService.getAllMeals()

        // Then
        Mockito.verify(mealSuggestionRepository).findAll()

    }

    @Test
    fun should_save_a_meal_suggestion() {

        // Given
        val mealSuggestion = MealSuggestion(1, "Omelette", "Omelette")

        val mealSuggestionRepository = Mockito.mock(MealSuggestionRepository::class.java)
        Mockito.`when`(mealSuggestionRepository.save(mealSuggestion)).thenReturn(mealSuggestion)

        val mealSuggestionService = MealSuggestionService(mealSuggestionRepository)

        // When
        mealSuggestionService.saveMeal(mealSuggestion)

        // Then
        val captor = ArgumentCaptor.forClass(MealSuggestion::class.java)
        Mockito.verify(mealSuggestionRepository).save(captor.capture())

        val expectedMealSuggestion = MealSuggestion(1, "Omelette", "Omelette")
        Assertions.assertThat(captor.value).isEqualTo(expectedMealSuggestion)

    }
}




