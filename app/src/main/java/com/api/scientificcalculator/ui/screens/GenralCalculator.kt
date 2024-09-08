package com.api.scientificcalculator.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navOptions
import com.api.scientificcalculator.ui.theme.Screens
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@Composable
fun GeneralCalculator(navController: NavHostController,) {
    val viewModel = viewModel<CalculatorViewModel>()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CalculatorTextField(
            minHeight = 220.dp
        )
Spacer(modifier = Modifier.height(30.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            content = {
                item {
                    CalculatorButton(
                        symbol = "AC",
                        color = ButtonDefaults.elevatedButtonColors(
                            MaterialTheme.colorScheme.errorContainer
                        ),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Clear)
                        }
                    )
                }

                item {
                    CalculatorButton(
                        symbol = "Del",
                        color = ButtonDefaults.elevatedButtonColors(
                            MaterialTheme.colorScheme.errorContainer
                        ),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Delete)
                        }
                    )
                }

                item {
                    CalculatorButton(
                        symbol = "%",
                        color = ButtonDefaults.elevatedButtonColors(
                            MaterialTheme.colorScheme.errorContainer
                        ),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Percentage))
                        }
                    )
                }

                item {
                    CalculatorButton(
                        symbol = "÷",
                        color = ButtonDefaults.elevatedButtonColors(
                            MaterialTheme.colorScheme.errorContainer
                        ),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                        }
                    )
                }

                item {
                    CalculatorButton(
                        symbol = "7",
                        color = ButtonDefaults.elevatedButtonColors(),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Number(7))
                        }
                    )
                }

                item {
                    CalculatorButton(
                        symbol = "8",
                        color = ButtonDefaults.elevatedButtonColors(),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Number(8))
                        }
                    )
                }

                item {
                    CalculatorButton(
                        symbol = "9",
                        color = ButtonDefaults.elevatedButtonColors(),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Number(9))
                        }
                    )
                }

                item {
                    CalculatorButton(
                        symbol = "×",
                        color = ButtonDefaults.elevatedButtonColors(
                            MaterialTheme.colorScheme.errorContainer
                        ),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                        }
                    )
                }

                item {
                    CalculatorButton(
                        symbol = "4",
                        color = ButtonDefaults.elevatedButtonColors(),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Number(4))
                        }
                    )
                }

                item {
                    CalculatorButton(
                        symbol = "5",
                        color = ButtonDefaults.elevatedButtonColors(),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Number(5))
                        }
                    )
                }

                item {
                    CalculatorButton(
                        symbol = "6",
                        color = ButtonDefaults.elevatedButtonColors(),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Number(6))
                        }
                    )
                }

                item {
                    CalculatorButton(
                        symbol = "-",
                        color = ButtonDefaults.elevatedButtonColors(
                            MaterialTheme.colorScheme.errorContainer
                        ),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                        }
                    )
                }

                item {
                    CalculatorButton(
                        symbol = "1",
                        color = ButtonDefaults.elevatedButtonColors(),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Number(1))
                        }
                    )
                }

                item {
                    CalculatorButton(
                        symbol = "2",
                        color = ButtonDefaults.elevatedButtonColors(),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Number(2))
                        }
                    )
                }

                item {
                    CalculatorButton(
                        symbol = "3",
                        color = ButtonDefaults.elevatedButtonColors(),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Number(3))
                        }
                    )
                }

                item {
                    CalculatorButton(
                        symbol = "+",
                        color = ButtonDefaults.elevatedButtonColors(
                            MaterialTheme.colorScheme.errorContainer
                        ),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                        }
                    )
                }

                item {
                    CalculatorButton(
                        symbol = "+/-",
                        color = ButtonDefaults.elevatedButtonColors(),
                        onClick = {
                            viewModel.onAction(CalculatorAction.PlusMinus)
                        }
                    )
                }

                item {
                    CalculatorButton(
                        symbol = "0",
                        color = ButtonDefaults.elevatedButtonColors(),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Number(0))
                        }
                    )
                }

                item {
                    CalculatorButton(
                        symbol = ".",
                        color = ButtonDefaults.elevatedButtonColors(),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Decimal)
                        }
                    )
                }

                item {
                    CalculatorButton(
                        symbol = "=",
                        color = ButtonDefaults.elevatedButtonColors(
                            MaterialTheme.colorScheme.errorContainer
                        ),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Calculate)
                        }
                    )
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerContent(
    navController: NavHostController,
    drawerState: DrawerState
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        item {
            Text(
                text = "Two in One Calculator App",
                modifier = Modifier.padding(20.dp),
                fontSize = 16.sp
            )
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(10.dp))

                NavigationDrawerItems(navController, drawerState)

                Spacer(modifier = Modifier.height(160.dp))

                Text(
                    text = "",
                    fontSize = 16.sp
                )
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawerItems(
    navController: NavHostController,
    drawerState: DrawerState
) {
    val scope = rememberCoroutineScope()
    val currentBackStackEntryAsState = navController.currentBackStackEntryAsState()
    val destination = currentBackStackEntryAsState.value?.destination
    val iconTint = MaterialTheme.colorScheme.primary


    NavigationDrawerItem(
        icon = {
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "General Calculator",
                tint = iconTint
            )
        },
        label = { Text(text = "General Calculator") },
        selected = destination?.route == Screens.GeneralCalculatorScreen.route,

        onClick = {
            navController.navigate(Screens.GeneralCalculatorScreen.route, navOptions {
                popUpTo(Screens.GeneralCalculatorScreen.route) {
                    saveState = true
                }
                this.launchSingleTop = true
                this.restoreState = true

            })
            scope.launch {
                drawerState.close()
            }
        },
        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
    )

    Spacer(modifier = Modifier.height(10.dp))

    NavigationDrawerItem(
        icon = {
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Scientific Calculator",
                tint = iconTint
            )
        },
        label = { Text(text = "Scientific Calculator") },
        selected = destination?.route == Screens.ScientificCalculatorScreen.route,

        onClick = {
            navController.navigate(Screens.ScientificCalculatorScreen.route, navOptions {
                popUpTo(Screens.GeneralCalculatorScreen.route) {
                    saveState = true
                }
                this.launchSingleTop = true
                this.restoreState = true

            })
            scope.launch {
                drawerState.close()
            }
        },
        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
    )
}