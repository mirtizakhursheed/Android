package com.irtiza.onboarding_presentation.nutrient_goal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.irtiza.core.R
import com.irtiza.core.util.UiEvent
import com.irtiza.core_ui.LocalSpacing
import com.irtiza.onboarding_presentation.welcome.components.ActionButton
import com.irtiza.onboarding_presentation.components.UnitTextField

@Composable
fun NutrientGoalScreen(
    snackbarHostState : SnackbarHostState,
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: NutrientGoalViewModel = hiltViewModel()
) {
   val spacing = LocalSpacing.current
   val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
           when(event) {
               is UiEvent.Navigate -> onNavigate(event)
               is UiEvent.ShowSnackBar-> {
                       snackbarHostState.showSnackbar(
                           message = event.message.asString(context)
                       )
               }
               else -> Unit
           }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceLarge)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.what_are_your_nutrient_goals),
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(modifier = Modifier.height(spacing.spaceMedium))

            UnitTextField(value = viewModel.state.carbsRatio, onValueChange = {
                viewModel.onEvent(NutrientGoalEvent.OnCarbRatioEnter(it))
            }, unit = stringResource(R.string.percent_carbs), modifier = Modifier)

            Spacer(modifier = Modifier.height(spacing.spaceMedium))

            UnitTextField(value = viewModel.state.proteinRatio, onValueChange = {
                viewModel.onEvent(NutrientGoalEvent.OnCarbRatioEnter(it))
            }, unit = stringResource(R.string.percent_proteins), modifier = Modifier)

            Spacer(modifier = Modifier.height(spacing.spaceMedium))

            UnitTextField(value = viewModel.state.fatRatio, onValueChange = {
                viewModel.onEvent(NutrientGoalEvent.OnCarbRatioEnter(it))
            }, unit = stringResource(R.string.percent_fats), modifier = Modifier)
        }

        ActionButton(
            text = stringResource(R.string.next),
            onClick = {
                viewModel.onEvent(NutrientGoalEvent.OnNextClick)
            },
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}