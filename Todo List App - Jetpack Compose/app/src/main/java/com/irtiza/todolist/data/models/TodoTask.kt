package com.irtiza.todolist.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.irtiza.todolist.enums.Priority
import com.irtiza.todolist.util.Constants.DATABASE_TABLE
import com.irtiza.todolist.util.Constants.ZERO

@Entity(tableName = DATABASE_TABLE)
data class TodoTask(
    @PrimaryKey(autoGenerate = true)
    val id : Int = ZERO,
    val title : String,
    val description : String,
    val priority : Priority
)
