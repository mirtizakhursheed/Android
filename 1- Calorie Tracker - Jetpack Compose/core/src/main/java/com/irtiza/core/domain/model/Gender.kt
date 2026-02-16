package com.irtiza.core.domain.model

sealed class Gender(val type: String) {
    data object Male : Gender("male")
    data object Female : Gender("female")

    companion object {
        fun fromString(type : String): Gender {
            return when(type) {
                "male" -> Male
                "female" -> Female
                else -> Female
            }
        }
    }
}