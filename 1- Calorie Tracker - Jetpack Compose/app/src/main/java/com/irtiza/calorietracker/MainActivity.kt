package com.irtiza.calorietracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.irtiza.calorietracker.ui.theme.CalorieTrackerTheme
import com.irtiza.core.navigation.Route
import com.irtiza.onboarding_presentation.welcome.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalorieTrackerTheme {
                val navController = rememberNavController()
                NavHost(navController = navController,
                    startDestination = Route.WELCOME_SCREEN) {
                    composable(Route.WELCOME_SCREEN) {
                      WelcomeScreen(onNavigate = navController::navigate)
                    }
                    composable(Route.AGE_SCREEN) {

                    }
                    composable(Route.GENDER_SCREEN) {

                    }
                    composable(Route.HEIGHT_SCREEN) {

                    }
                    composable(Route.WEIGHT_SCREEN) {

                    }
                    composable(Route.NUTRIENT_GOAL_SCREEN) {

                    }
                    composable(Route.ACTIVITY_SCREEN) {

                    }
                    composable(Route.GOAL_SCREEN) {

                    }
                    composable(Route.TRACKER_OVERVIEW_SCREEN) {

                    }
                    composable(Route.SEARCH_SCREEN) {

                    }
                }
            }
        }
    }
}