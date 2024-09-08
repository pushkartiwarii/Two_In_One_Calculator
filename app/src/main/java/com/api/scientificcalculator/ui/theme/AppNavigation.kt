package com.api.scientificcalculator.ui.theme

import android.annotation.SuppressLint
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.api.scientificcalculator.ui.screens.DrawerContent
import com.api.scientificcalculator.ui.screens.GeneralCalculator
import com.api.scientificcalculator.ui.screens.ScientificCalculator
import kotlinx.coroutines.launch

sealed class Screens(val route: String) {

    object GeneralCalculatorScreen: Screens("general_calculator")
    object ScientificCalculatorScreen: Screens("scientific_calculator")

}

@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()




    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(navController, drawerState)
        }
    ) {
        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    modifier = Modifier.padding(horizontal = 2.dp),
                    navigationIcon = {
                        IconButton(onClick = {

                            if (drawerState.isClosed) {
                                scope.launch {
                                    drawerState.open()
                                }
                            } else {
                                scope.launch {
                                    drawerState.close()
                                }
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Filled.MoreVert,
                                contentDescription = "Menu Icon"
                            )
                        }
                    },
                    scrollBehavior = scrollBehavior
                )
            }
        ) {
            Box(
                modifier = Modifier.padding(it)
            ) {
                NavHost(
                    navController = navController,
                    startDestination = Screens.GeneralCalculatorScreen.route
                ) {
                    composable(route = Screens.GeneralCalculatorScreen.route,
                        enterTransition = {
                            slideIn(
                                initialOffset = { size ->
                                    IntOffset(size.width, size.height)
                                }
                            )

                        },
                        exitTransition = {
                            slideOut(
                                targetOffset = { size ->
                                    IntOffset(size.width, size.height)
                                }
                            )
                        }) {

                        GeneralCalculator(
                            navController
                        )
                    }
                    composable(route = Screens.ScientificCalculatorScreen.route,
                        enterTransition ={
                            slideIn(
                                initialOffset = { size ->
                                    IntOffset(size.width, size.height)
                                }
                            )
                        },
                        exitTransition = {
                            slideOut(
                                targetOffset = { size ->
                                    IntOffset(size.width, size.height)
                                }
                            )
                        }) {
                        ScientificCalculator(navController)
                    }
                }
            }
        }
    }
}