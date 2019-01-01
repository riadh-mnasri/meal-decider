package com.riadh.mealdecider.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id

@Entity(name="MEAL_SUGGESTION")
data class MealSuggestion(@Id @GeneratedValue(strategy = IDENTITY) val id: Int,
                          val name: String,
                          val description: String)
