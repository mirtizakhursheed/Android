package com.irtiza.onboarding_presentation.age

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irtiza.core.domain.preferences.Preferences
import com.irtiza.core.navigation.Route
import com.irtiza.core.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgeViewModel @Inject constructor(
    private val preferences: Preferences
): ViewModel() {

    var age by mutableStateOf<String>("20")
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onGenderEnter(age: String) {
        if(age.length <=3) {
            this.age = age
        }
    }

    fun onNextClick() {
        viewModelScope.launch {
            preferences.saveAge(age.toInt())
            _uiEvent.send(UiEvent.Navigate(Route.AGE_SCREEN))
        }
    }

}