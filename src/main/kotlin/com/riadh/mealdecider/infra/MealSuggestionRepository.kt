package com.riadh.mealdecider.infra

import com.riadh.mealdecider.domain.MealSuggestion
import org.springframework.data.repository.CrudRepository

interface MealSuggestionRepository : CrudRepository<MealSuggestion, Int>
