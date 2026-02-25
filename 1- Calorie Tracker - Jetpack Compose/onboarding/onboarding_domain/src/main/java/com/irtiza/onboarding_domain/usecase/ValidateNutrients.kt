package com.irtiza.onboarding_domain.usecase

import com.irtiza.core.R
import com.irtiza.core.util.UiText


class ValidateNutrients {

    operator fun invoke(carbsRatioText: String, proteinRatioText: String, fatRatioText: String) : Result {

        val carbsRatio = carbsRatioText.toIntOrNull()
        val proteinRatio = proteinRatioText.toIntOrNull()
        val fatRatio = fatRatioText.toIntOrNull()

        return if(carbsRatio == null || proteinRatio == null || fatRatio == null) {
            Result.Error(message = UiText.StringResource(R.string.error_invalid_values))
        } else if(carbsRatio + proteinRatio + fatRatio != 100) {
            Result.Error(message = UiText.StringResource(R.string.error_not_100_percent))
        } else {
            Result.Success(carbsRatio / 100f ,proteinRatio / 100f ,fatRatio / 100f )
        }

    }

    sealed class Result {
        data class Success(
            val carbsRatio: Float,
            val proteinRatio: Float,
            val fatRatio: Float
        ): Result()

        data class Error(val message: UiText): Result()
    }
}