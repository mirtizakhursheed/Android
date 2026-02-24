package com.irtiza.onboarding_domain.usecase

import com.irtiza.core.util.UiText

class ValidateNutrients {

    operator fun invoke(carbsRatio: String, proteinRatio: String, fatRatio: String) {

    }

    sealed class Result {
        data class Success(
            val carbsRatio: Int,
            val proteinRatio: Int,
            val fatRatio: Int
        ): Result()

        data class Error(val message: UiText): Result()
    }
}