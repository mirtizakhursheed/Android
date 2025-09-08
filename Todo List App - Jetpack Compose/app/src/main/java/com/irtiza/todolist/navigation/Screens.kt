package com.irtiza.todolist.navigation

import androidx.navigation.NavController
import com.irtiza.todolist.enums.Action
import com.irtiza.todolist.util.Constants.LIST_SCREEN
import com.irtiza.todolist.util.Constants.TASK_SCREEN

class Screens(navController: NavController) {
    val list : (Action) -> Unit = { action ->
        navController.navigate("list/${action.name}", builder = {
            popUpTo(LIST_SCREEN) { inclusive = true }
        })
    }

    val task : (Int) -> Unit = { taskId ->
        navController.navigate("task/${taskId}") {
            popUpTo(TASK_SCREEN) { inclusive = true }
        }
    }


}