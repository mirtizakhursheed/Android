package com.irtiza.onboarding_domain.di

import com.irtiza.onboarding_domain.usecase.ValidateNutrients
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object OnBoardingDomainModule {

    @Provides
    @ViewModelScoped
    fun providesValidateNutrientsUseCase(): ValidateNutrients {
        return ValidateNutrients()
    }

}