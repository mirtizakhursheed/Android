package com.irtiza.calorietracker.navigation

import androidx.navigation.NavController
import com.irtiza.core.util.UiEvent

fun NavController.navigateScreen(event: UiEvent.Navigate) {
    this.navigate(event.route)
}