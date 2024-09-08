package com.api.scientificcalculator.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.navOptions
import com.api.scientificcalculator.ui.theme.Screens

data class Tools(
    val title: String,
    val icon: ImageVector
)
class ToolsRepository {
    fun getToolsData(): List<Tools> {
        return listOf(

            Tools(
                title = "General Calculator",
                icon = Icons.Default.KeyboardArrowRight
            ),

            Tools(
                title = "Scientific Calculator",
                icon = Icons.Default.KeyboardArrowRight
            ),


        )
    }
}



@ExperimentalMaterial3Api
@Composable
fun ToolsItem(
    tools:Tools,
    navController: NavController
) {
    ElevatedCard(
        modifier = Modifier
            .size(
                width = 130.dp,
                height = 100.dp
            )
            .padding(10.dp),
        onClick = {
            when(tools.title) { "General Calculator" -> navController.navigate(
                Screens.GeneralCalculatorScreen.route,
                navOptions {
                    Screens.GeneralCalculatorScreen.route

                    this.launchSingleTop = true
                    this.restoreState = true
                }
            )

                "Scientific Calculator" -> navController.navigate(
                    Screens.ScientificCalculatorScreen.route,
                    navOptions {
                        Screens.GeneralCalculatorScreen.route

                        this.launchSingleTop = true
                        this.restoreState = true
                    }
                )
            }
        },
        colors = CardDefaults.elevatedCardColors(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp,
            pressedElevation = 10.dp
        )
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = tools.icon,
                contentDescription = tools.title,
                modifier = Modifier
                    .size(48.dp)
                    .padding(end = 8.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Text(
                text = tools.title,
                fontSize = MaterialTheme.typography.labelSmall.fontSize,
                fontWeight = MaterialTheme.typography.headlineMedium.fontWeight
            )
        }
    }
}







