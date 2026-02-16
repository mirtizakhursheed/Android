package com.irtiza.core.domain.model

sealed class GoalType(val type: String) {
    data object LoseWeight : GoalType("lose_weight")
    data object KeepWeight : GoalType("keep_weight")
    data object GainWeight : GoalType("gain_weight")

    companion object {
        fun fromString(type : String): GoalType {
            return when(type) {
                "lose_weight" -> LoseWeight
                "keep_weight" -> KeepWeight
                "gain_weight" -> GainWeight
                else -> GainWeight
            }
        }
    }
}