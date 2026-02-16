package com.irtiza.core.domain.model

sealed class ActivityLevel(val level: String) {
    data object Low : ActivityLevel("low")
    data object Medium : ActivityLevel("medium")
    data object High : ActivityLevel("high")

    companion object {
        fun fromString(level : String): ActivityLevel {
            return when(level) {
                "low" -> Low
                "medium" -> Medium
                "high" -> High
                else -> High
            }
        }
    }
}