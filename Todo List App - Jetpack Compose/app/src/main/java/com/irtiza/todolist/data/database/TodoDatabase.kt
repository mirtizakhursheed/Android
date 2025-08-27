package com.irtiza.todolist.data.database

import androidx.room.Database
import com.irtiza.todolist.data.dao.TodoDao
import com.irtiza.todolist.data.models.TodoTask

@Database(entities = [TodoTask::class], version = 1, exportSchema = false)
abstract class TodoDatabase {

    abstract fun todoDao() : TodoDao

}