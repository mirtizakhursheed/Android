package com.irtiza.calorietracker

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.irtiza.calorietracker.navigation.navigateScreen
import com.irtiza.calorietracker.ui.theme.CalorieTrackerTheme
import com.irtiza.core.domain.model.GoalType
import com.irtiza.core.navigation.Route
import com.irtiza.onboarding_presentation.activity.ActivityScreen
import com.irtiza.onboarding_presentation.age.AgeScreen
import com.irtiza.onboarding_presentation.gender.GenderScreen
import com.irtiza.onboarding_presentation.goal.GoalScreen
import com.irtiza.onboarding_presentation.welcome.WelcomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalorieTrackerTheme {
                val navController = rememberNavController()
                val snackbarHostState = remember { SnackbarHostState() }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = {
                        SnackbarHost(hostState = snackbarHostState)
                    }) {
                    NavHost(
                        navController = navController,
                        startDestination = Route.WELCOME_SCREEN
                    ) {
                        composable(Route.WELCOME_SCREEN) {
                            WelcomeScreen(onNavigate = navController::navigateScreen)
                        }
                        composable(Route.AGE_SCREEN) {
                            AgeScreen(
                                snackbarHostState = snackbarHostState,
                                onNavigate = navController::navigateScreen)
                        }
                        composable(Route.GENDER_SCREEN) {
                            GenderScreen(onNavigate = navController::navigateScreen)
                        }
                        composable(Route.HEIGHT_SCREEN) {

                        }
                        composable(Route.WEIGHT_SCREEN) {

                        }
                        composable(Route.NUTRIENT_GOAL_SCREEN) {

                        }
                        composable(Route.ACTIVITY_SCREEN) {
                            ActivityScreen(onNavigate = navController::navigateScreen)
                        }
                        composable(Route.GOAL_SCREEN) {
                            GoalScreen(onNavigate = navController::navigateScreen)
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
}