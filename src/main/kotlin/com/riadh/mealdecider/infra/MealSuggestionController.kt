package com.riadh.mealdecider.infra

import com.riadh.mealdecider.domain.MealSuggestion
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux
import reactor.core.publisher.toMono
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping

@RestController
@RequestMapping("/api")
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

    @GetMapping("/mealSuggestion/{id}")
    fun getMealSuggestionbyId(@PathVariable("id") id: Int): Mono<ResponseEntity<MealSuggestion>> {
        return mealSuggestionService.getMealById(id)
            .map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity(HttpStatus.NOT_FOUND))
            .toMono()
    }

    @PostMapping("/mealSuggestion/save")
    fun saveMealSuggestion(@RequestBody mealSuggestion: MealSuggestion): Mono<MealSuggestion> {
        return mealSuggestionService.saveMeal(mealSuggestion).toMono()
    }

    @PostMapping("/mealSuggestion/delete/{id}")
    fun deleteMealSuggestion(@PathVariable("id") id: Int){
        return mealSuggestionService.deleteMealById(id)
    }

}
