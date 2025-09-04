package com.irtiza.todolist.navigation

import androidx.navigation.NavController
import com.irtiza.todolist.enums.Action

class Screens(navController: NavController) {
    val list : (Action) -> Unit = { action ->
        navController.navigate("list/${action.name}")
    }
}