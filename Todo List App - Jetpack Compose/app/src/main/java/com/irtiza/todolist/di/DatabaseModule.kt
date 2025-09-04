package com.irtiza.todolist.di

import android.content.Context
import androidx.room.Room
import com.irtiza.todolist.data.database.TodoDatabase
import com.irtiza.todolist.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun providesDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, TodoDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideTodoDao(todoDatabase: TodoDatabase) = todoDatabase.todoDao()
}