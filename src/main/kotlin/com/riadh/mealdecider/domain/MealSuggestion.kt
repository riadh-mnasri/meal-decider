package com.riadh.mealdecider.domain

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class MealSuggestion(@Id val id: Int, val name: String, val description: String)
