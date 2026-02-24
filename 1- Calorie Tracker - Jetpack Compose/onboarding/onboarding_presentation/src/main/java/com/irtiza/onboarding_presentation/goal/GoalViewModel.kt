package com.irtiza.onboarding_presentation.goal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irtiza.core.domain.model.ActivityLevel
import com.irtiza.core.domain.model.GoalType
import com.irtiza.core.domain.preferences.Preferences
import com.irtiza.core.navigation.Route
import com.irtiza.core.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GoalViewModel @Inject constructor(
    private val preferences: Preferences
): ViewModel() {

    var selectedGoalType by mutableStateOf<GoalType>(GoalType.LoseWeight)
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onGoalTypeSelect(goalType: GoalType) {
        selectedGoalType = goalType
    }

    fun onNextClick() {
        viewModelScope.launch {
            preferences.saveGoalType(selectedGoalType)
            _uiEvent.send(UiEvent.Navigate(Route.NUTRIENT_GOAL_SCREEN))
        }
    }

}