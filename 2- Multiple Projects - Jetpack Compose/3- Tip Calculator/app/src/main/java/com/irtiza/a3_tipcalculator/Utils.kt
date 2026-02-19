package com.irtiza.a3_tipcalculator

import android.icu.text.DecimalFormat

fun getTipAmount(userAmount: String , tipPercentage: Float) : Float {
    val value = when {
        userAmount.isEmpty() -> 0f
        else -> {
            val amount = userAmount.toFloat()
            (amount * tipPercentage.div(100))
        }
    }

    return floatToDecimal(value)
}
fun getTotalHeaderAmount(amount: String , personCounter: Int , tipPercentage: Float ): Float {
    return when{
        amount.isEmpty() -> 0f
        else -> {
            val userAmount = amount.toFloat()
            val tipAmount = (userAmount * tipPercentage).div(100)
            val perheadAmount = (userAmount+tipAmount).div(personCounter)
            floatToDecimal(perheadAmount)
        }
    }
}


fun floatToDecimal(amount : Float) : Float {
    val format = DecimalFormat("###############.##")
    return format.format(amount).toFloat()
}