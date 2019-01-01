package com.riadh.mealdecider.infra

import com.riadh.mealdecider.domain.MealSuggestion
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux
import reactor.core.publisher.toMono

@RestController
@RequestMapping
class MealSuggestionController(val mealSuggestionService: MealSuggestionService){

    @GetMapping("/meals")
    fun getAllMealsSuggestions(): Flux<MealSuggestion>{
        return mealSuggestionService.getAllMeals().toFlux()
    }

    @GetMapping("/mealSuggestion")
    fun getRandomSuggestion(): Mono<MealSuggestion> {
        val foundSuggestion = mealSuggestionService.getRandomMealSuggestion() ?: return Mono.empty<MealSuggestion>()
        return foundSuggestion.toMono()
    }


}
