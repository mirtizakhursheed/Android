package com.irtiza.todolist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irtiza.todolist.data.models.TodoTask
import com.irtiza.todolist.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor( private val repository: TodoRepository) : ViewModel() {

    private val _allTask =  MutableStateFlow<List<TodoTask>>(emptyList())
    val alltask : StateFlow<List<TodoTask>> = _allTask

    fun getAllTask() {
        repository.getAllTask.onEach { list ->
            _allTask.value = list

        }.launchIn(viewModelScope)
    }
}