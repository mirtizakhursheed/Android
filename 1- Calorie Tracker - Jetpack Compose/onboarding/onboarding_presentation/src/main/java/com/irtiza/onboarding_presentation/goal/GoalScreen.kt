package com.irtiza.onboarding_presentation.goal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.irtiza.core.R
import com.irtiza.core.domain.model.GoalType
import com.irtiza.core.util.UiEvent
import com.irtiza.core_ui.LocalSpacing
import com.irtiza.onboarding_presentation.components.SelectableButton
import com.irtiza.onboarding_presentation.welcome.components.ActionButton

@Composable
fun GoalScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: GoalViewModel = hiltViewModel()
) {
   val spacing = LocalSpacing.current

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
           when(event) {
               is UiEvent.Navigate -> onNavigate(event)
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
                text = stringResource(id = R.string.lose_keep_or_gain_weight),
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(modifier = Modifier.height(spacing.spaceMedium))

            Row {
                SelectableButton(
                    text = stringResource(R.string.lose),
                    isSelected = viewModel.selectedGoalType is GoalType.LoseWeight,
                    color = MaterialTheme.colorScheme.primary,
                    selectedTextColor = Color.White,
                    onClick = {
                        viewModel.onGoalTypeSelect(GoalType.LoseWeight)
                    },
                    textStyle = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))

                SelectableButton(
                    text = stringResource(R.string.keep),
                    isSelected = viewModel.selectedGoalType is GoalType.KeepWeight,
                    color = MaterialTheme.colorScheme.primary,
                    selectedTextColor = Color.White,
                    onClick = {
                        viewModel.onGoalTypeSelect(GoalType.KeepWeight)
                    },
                    textStyle = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.width(spacing.spaceMedium))

                SelectableButton(
                    text = stringResource(R.string.gain),
                    isSelected = viewModel.selectedGoalType is GoalType.GainWeight,
                    color = MaterialTheme.colorScheme.primary,
                    selectedTextColor = Color.White,
                    onClick = {
                        viewModel.onGoalTypeSelect(GoalType.GainWeight)
                    },
                    textStyle = MaterialTheme.typography.bodyLarge
                )
            }
        }

        ActionButton(
            text = stringResource(R.string.next),
            onClick = {
                viewModel.onNextClick()
            },
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}