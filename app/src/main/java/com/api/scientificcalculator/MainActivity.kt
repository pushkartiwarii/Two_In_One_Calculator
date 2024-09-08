package com.api.scientificcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import com.api.scientificcalculator.ui.screens.ScientificCalculator
import com.api.scientificcalculator.ui.theme.MainScreen
import com.api.scientificcalculator.ui.theme.ScientificCalculatorTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScientificCalculatorTheme {
               MainScreen()



            }
        }
    }
}
