package com.irtiza.core.domain.model

data class UserInfo(
    val gender: Gender,
    val height: Int,
    val age: Int,
    val weight: Float,
    val activityLevel: ActivityLevel,
    val goalType: GoalType,
    val carbRatio: Float,
    val proteinRatio: Float,
    val fatRatio: Float

)
