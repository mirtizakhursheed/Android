package com.irtiza.a3_tipcalculator

import android.icu.text.DecimalFormat
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun TipCalculator() {
    val amount = remember { mutableStateOf("") }
    val personCounter = remember { mutableIntStateOf(1) }
    val tipPercentage = remember { mutableFloatStateOf(0f) }
    Column(modifier = Modifier.fillMaxWidth()) {
        TotalHeader(amount = getTotalHeaderAmount(amount.value , personCounter.intValue , tipPercentage.floatValue))
        UserInputArea(amount.value, {
            amount.value = it
        }, tipPercentage.floatValue, {
            tipPercentage.value = it
        },personCounter.intValue, { addOrReduce ->
            if(addOrReduce < 0) {
                if(personCounter.value != 1) {
                    personCounter.value--
                }
            }
            else {
                personCounter.value++
            }
        })

    }
}

@Composable
fun TotalHeader(amount: Float) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        color = MaterialTheme.colorScheme.primary,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {

            Text(text = "Total Per Person", style = MaterialTheme.typography.headlineSmall)

            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "$ $amount", style = MaterialTheme.typography.headlineLarge)
        }
    }
}

@Composable
fun UserInputArea(amount: String, amountChange: (String) -> Unit,
                  tipPercentage: Float, tipPercentageChange:  (Float) -> Unit,
                  personCounter : Int, onAddOrReducePerson: (Int) -> Unit) {

    val keyboardController = LocalSoftwareKeyboardController.current

    Surface(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 10.dp), shape = RoundedCornerShape(10.dp),
        shadowElevation = 12.dp) {

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {

            OutlinedTextField(value = amount, onValueChange = { amountChange.invoke(it)},
                modifier = Modifier.fillMaxWidth(), placeholder = { Text("Enter Your Amount") },
                keyboardOptions = KeyboardOptions(autoCorrectEnabled = true , keyboardType = KeyboardType.Number , imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    keyboardController?.hide()
                })
            )

            if(amount.isNotEmpty() && amount.toFloat() > 0f ) {


                Spacer(Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp), verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(text = "Split", style = MaterialTheme.typography.headlineLarge)
                    Spacer(Modifier.fillMaxWidth(.50f))
                    CustomButton(imageVector = Icons.Default.KeyboardArrowUp, {
                        onAddOrReducePerson.invoke(1)
                    })

                    Text(
                        text = "$personCounter",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )

                    CustomButton(imageVector = Icons.Default.KeyboardArrowDown, {
                        onAddOrReducePerson.invoke(-1)
                    })
                }

                Spacer(Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth().padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Tip",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )
                    Spacer(Modifier.fillMaxWidth(.70f))
                    Text(
                        text = "$${getTipAmount(amount, tipPercentage)}",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )

                }

                Spacer(Modifier.height(10.dp))

                Text(text = "${tipPercentage}%", style = MaterialTheme.typography.titleLarge)

                Spacer(Modifier.height(10.dp))

                Slider(
                    modifier = Modifier.fillMaxWidth(),
                    value = tipPercentage,
                    valueRange = 0f..100f,
                    steps = 5,
                    onValueChange = {
                        tipPercentageChange.invoke(floatToDecimal(it))
                    })
            }


        }

    }
}


@Composable
fun CustomButton(imageVector: ImageVector,  onClick: () -> Unit) {
    Card(modifier = Modifier
        .wrapContentSize()
        .padding(12.dp).clickable {
            onClick.invoke()
        }, shape = CircleShape
    ) {
        Icon(imageVector = imageVector, contentDescription = null, modifier = Modifier
            .size(30.dp)
            .padding(4.dp))
    }
}


