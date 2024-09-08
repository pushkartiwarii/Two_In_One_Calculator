package com.api.scientificcalculator.ui.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.WindowInfo
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.api.scientificcalculator.ui.theme.rememberWindowInfo

sealed class CalculatorOperation(
    val symbol: String
) {
    object Add: CalculatorOperation("+")
    object Subtract: CalculatorOperation("-")
    object Multiply: CalculatorOperation("×")
    object Divide: CalculatorOperation("÷")
    object Percentage: CalculatorOperation("%")
    object Modulus: CalculatorOperation("mod")
    object And: CalculatorOperation("&")
    object Or: CalculatorOperation("|")
    object Xor: CalculatorOperation("^")
    object RightShift: CalculatorOperation(">>")
    object LeftShift: CalculatorOperation("<<")
    object PowerToY: CalculatorOperation("^")
    object Sin: CalculatorOperation("sin")
    object Cos: CalculatorOperation("cos")
    object Tan: CalculatorOperation("tan")

}

sealed class CalculatorAction{
    data class Number(val number: Int): CalculatorAction()
    object Clear: CalculatorAction()
    object Delete: CalculatorAction()
    data class Operation(val operation: CalculatorOperation): CalculatorAction()
    object Calculate: CalculatorAction()
    object Decimal: CalculatorAction()
    object PlusMinus: CalculatorAction()
    object DecToBin: CalculatorAction()
    object DecToHex: CalculatorAction()
    object DecToOct: CalculatorAction()
    object Not: CalculatorAction()
    object Pi: CalculatorAction()
    object Exponent: CalculatorAction()
    object Log: CalculatorAction()
    object Ln: CalculatorAction()
    object Square: CalculatorAction()
    object Root: CalculatorAction()
    object ConvertToFahr: CalculatorAction()
    object ConvertToCel: CalculatorAction()
}

class SuperSubTextStyle {
    val superScript = SpanStyle(
        baselineShift = BaselineShift.Superscript,
        fontSize = 12.sp
    )

    val subScript = SpanStyle(
        baselineShift = BaselineShift.Subscript,
        fontSize = 12.sp
    )
}
data class WindowInfo(
    val screenWidthInfo: WindowType,
    val screenHeightInfo: WindowType,
    val screenWidth: Dp,
    val screenHeight: Dp
) {
    sealed class WindowType {
        object Compact: WindowType()
        object Medium: WindowType()
        object Expanded: WindowType()
    }
}
@ExperimentalMaterial3Api
@Composable
fun ScientificCalculator(navController: NavController,) {
    val viewModel = viewModel<CalculatorViewModel>()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CalculatorTextField(
            minHeight = 220.dp,
            horizontalPadding = 10.dp
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(5),
            modifier = Modifier
                .padding(
                    horizontal = 4.dp,
                    vertical = 16.dp
                )
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
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
                        symbol = "π",
                        color = ButtonDefaults.elevatedButtonColors(
                            MaterialTheme.colorScheme.errorContainer
                        ),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Pi)
                        }
                    )
                }

                item {
                    CalculatorButton(
                        symbol = "e",
                        color = ButtonDefaults.elevatedButtonColors(
                            MaterialTheme.colorScheme.errorContainer
                        ),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Exponent)
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
                        symbol = "sin",
                        color = ButtonDefaults.elevatedButtonColors(),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Sin))
                        }
                    )
                }

                item {
                    CalculatorButton(
                        symbol = "x",
                        superScript = "y",
                        color = ButtonDefaults.elevatedButtonColors(),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.PowerToY))
                        }
                    )
                }

                item {
                    CalculatorButton(
                        symbol = "x",
                        superScript = "2",
                        color = ButtonDefaults.elevatedButtonColors(),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Square)
                        }
                    )
                }

                item {
                    CalculatorButton(
                        symbol = "√",
                        color = ButtonDefaults.elevatedButtonColors(),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Root)
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
                        symbol = "cos",
                        color = ButtonDefaults.elevatedButtonColors(),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Cos))
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
                        symbol = "tan",
                        color = ButtonDefaults.elevatedButtonColors(),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Tan))
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
                        symbol = "log",
                        color = ButtonDefaults.elevatedButtonColors(),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Log)
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
                        symbol = "ln",
                        color = ButtonDefaults.elevatedButtonColors(),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Ln)
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

@Composable
fun CalculatorButton(
    enable: Boolean = true,
    symbol: String,
    superScript: String? = "",
    subScript: String? = "",
    color: ButtonColors,
    onClick: ()-> Unit
) {
    val superSubTextStyle = SuperSubTextStyle()
    ElevatedButton(
        modifier = Modifier
            .size(50.dp),
        colors = color,
        enabled = enable,
        shape = RoundedCornerShape(20.dp),
        onClick = onClick
    ) {
        Text(
            text = buildAnnotatedString{
                append(symbol)
                withStyle(superSubTextStyle.superScript) {
                    append(superScript)
                }
                withStyle(superSubTextStyle.subScript) {
                    append(subScript)
                }
            },
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            fontStyle = MaterialTheme.typography.labelMedium.fontStyle
        )
    }
}

@ExperimentalMaterial3Api
@Composable
fun CalculatorTextField(
    minHeight: Dp,
    horizontalPadding: Dp = 20.dp
) {
    val viewModel = viewModel<CalculatorViewModel>()
    val state = viewModel.state
    val windowInfo = rememberWindowInfo()

    ElevatedCard(
        modifier = Modifier
            .padding(
                horizontal = horizontalPadding,
                vertical = 10.dp
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(
                    min= if(
                        windowInfo.screenWidthInfo is com.api.scientificcalculator.ui.screens.WindowInfo.WindowType.Compact
                    ) {
                        minHeight
                    } else {
                        80.dp
                    },
                    max = 230.dp
                )
        ) {
            val text = state.number1 + (state.operation?.symbol ?: "") + state.number2
            Text(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp),
                text = text,
                fontSize = if(text.length < 17) {
                    MaterialTheme.typography.headlineLarge.fontSize
                } else {
                    MaterialTheme.typography.headlineMedium.fontSize
                },
                lineHeight = 32.sp
            )
        }
    }
}