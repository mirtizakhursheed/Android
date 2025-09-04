package com.irtiza.todolist.repository

import com.irtiza.todolist.data.dao.TodoDao
import com.irtiza.todolist.data.models.TodoTask
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class TodoRepository @Inject constructor(private val todoDao: TodoDao) {

    val getAllTask : Flow<List<TodoTask>> = todoDao.getAllTasks()
    val sortByLowPriority : Flow<List<TodoTask>> = todoDao.sortByLowPriority()
    val sortByHighPriority : Flow<List<TodoTask>> = todoDao.sortByHighPriority()

    fun getSelectedTask(taskId: Int): Flow<TodoTask> = todoDao.getSelectedTask(taskId)

    suspend fun addTask(todoTask: TodoTask) = todoDao.addTask(todoTask)

    suspend fun deleteTask(todoTask: TodoTask) = todoDao.deleteTask(todoTask)

    suspend fun updateTask(todoTask: TodoTask) = todoDao.updateTask(todoTask)

    suspend fun deleteAllTasks() = todoDao.deleteAllTasks()

    fun searchDatabase(searchQuery: String): Flow<List<TodoTask>> = todoDao.searchDatabase(searchQuery)




}