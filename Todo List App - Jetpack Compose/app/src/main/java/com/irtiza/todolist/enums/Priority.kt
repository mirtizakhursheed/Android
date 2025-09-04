package com.irtiza.todolist.enums

import androidx.compose.ui.graphics.Color
import com.irtiza.todolist.ui.theme.HighPriorityColor
import com.irtiza.todolist.ui.theme.LowPriorityColor
import com.irtiza.todolist.ui.theme.MediumPriorityColor
import com.irtiza.todolist.ui.theme.NonePriorityColor


enum class Priority(val color: Color) {
 HIGH(HighPriorityColor),
 MEDIUM(MediumPriorityColor),
 LOW(LowPriorityColor),
 NONE(NonePriorityColor)
}