package com.riadh.mealdecider.infra

import com.riadh.mealdecider.domain.MealSuggestion
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.toFlux

@RestController
@RequestMapping("/meals")
class MealSuggestionController(val mealSuggestionRepository: MealSuggestionRepository){

    @GetMapping
    fun getAllMealsSuggestions(): Flux<MealSuggestion>{
        return mealSuggestionRepository.findAll().toFlux()
    }

}
