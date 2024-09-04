package com.example.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tipcalculator.ui.theme.TipCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TipCalculatorTheme {
                ScreenCalculator()
            }
        }
    }
}

@Composable
fun ScreenCalculator(modifier: Modifier = Modifier){
    
    var valueInput by remember { mutableStateOf("") }
    
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp, vertical = 20.dp)
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.Start,


    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(30.dp))

        TextFieldsForCalculator(value = valueInput, onChangeValue = {valueInput = it})

        Spacer(modifier = Modifier.height(30.dp))


        Text(
            text = stringResource(id = R.string.description_tip) + " 0.00$",
            fontSize = 30.sp,
            modifier = modifier.align(alignment = Alignment.Start)
            )
    }
}

@Composable
fun TextFieldsForCalculator(
    modifier: Modifier = Modifier,
    value : String,
    onChangeValue : (String) -> Unit
){
    TextField(
        value = value,
        onValueChange = onChangeValue,
        label = { Text(text = stringResource(id = R.string.bill))}

    )
}

fun calculateValueTip(value : Double, percentage : Double){

}

@Preview(showBackground = true)
@Composable
fun AllScreenPreview(){
    ScreenCalculator()
}