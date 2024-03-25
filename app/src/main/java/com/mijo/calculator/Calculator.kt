package com.mijo.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Text
import com.mijo.calculator.ui.theme.numberColor
import com.mijo.calculator.ui.theme.operatorColor

@Composable
fun Calculator(
    state: CalculatorState,
    modifier: Modifier = Modifier,
    onAction: (CalculatorAction) -> Unit,
) {

    val screenWidth = Size().width()
    val ratio = Size().ratio()

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(CircleShape)
            .width(screenWidth.dp)
            .height(screenWidth.dp)
            .then(modifier)
    )
    {
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)

        ) {
            Box() {
                Text(
                    text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                    textAlign = TextAlign.End,
                    modifier = modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .height((160 * ratio).dp)
                        .padding(top = (60 * ratio).dp)
                        .padding(horizontal = (90 * ratio).dp),
                    fontWeight = FontWeight.Light,
                    fontSize = (45 * ratio).sp,
                    color = Color.White,
                    maxLines = 2,
                )
            }
            Box() {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    // Row 1 ===========================
                    Row()
                    {
                        CalculatorButton(
                            symbol = "7",
                            modifier = Modifier
                                .background(numberColor),
                            onClick = { onAction(CalculatorAction.Number(7)) }
                        )
                        CalculatorButton(
                            symbol = "8",
                            modifier = Modifier
                                .background(numberColor),
                            onClick = { onAction(CalculatorAction.Number(8)) }
                        )
                        CalculatorButton(
                            symbol = "9",
                            modifier = Modifier
                                .background(numberColor),
                            onClick = { onAction(CalculatorAction.Number(9)) }
                        )

                        CalculatorButton(
                            symbol = "⇦",//"\uD83D\uDD19",
                            modifier = Modifier
                                .background(operatorColor),
                            onClick = { onAction(CalculatorAction.Delete) },
                            textColor = Color.Red,
                            icon = Icons.Sharp.ArrowBack,
                        )
                        CalculatorButton(
                            symbol = "C",
                            modifier = Modifier
                                .background(operatorColor),
                            onClick = { onAction(CalculatorAction.Clear) },
                            textColor = Color.Red
                        )
                    }

                    // Row 2 ===========================
                    Row()
                    {
                        CalculatorButton(
                            symbol = "4",
                            modifier = Modifier
                                .background(numberColor),
                            onClick = { onAction(CalculatorAction.Number(4)) }
                        )
                        CalculatorButton(
                            symbol = "5",
                            modifier = Modifier
                                .background(numberColor),
                            onClick = { onAction(CalculatorAction.Number(5)) }
                        )
                        CalculatorButton(
                            symbol = "6",
                            modifier = Modifier
                                .background(numberColor),
                            onClick = { onAction(CalculatorAction.Number(6)) }
                        )
                        CalculatorButton(
                            symbol = "+",
                            modifier = Modifier
                                .background(operatorColor),
                            textColor = Color.Yellow,
                            onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Add)) }
                        )
                        CalculatorButton(
                            symbol = "x",
                            modifier = Modifier
                                .background(operatorColor),
                            textColor = Color.Yellow,
                            onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Multiply)) }
                        )

                    }
                    // Row 3 ===========================
                    Row()
                    {
                        CalculatorButton(
                            symbol = "1",
                            modifier = Modifier
                                .background(numberColor),
                            onClick = { onAction(CalculatorAction.Number(1)) }
                        )
                        CalculatorButton(
                            symbol = "2",
                            modifier = Modifier
                                .background(numberColor),
                            onClick = { onAction(CalculatorAction.Number(2)) }
                        )
                        CalculatorButton(
                            symbol = "3",
                            modifier = Modifier
                                .background(numberColor),
                            onClick = { onAction(CalculatorAction.Number(3)) }
                        )
                        CalculatorButton(
                            symbol = "-",
                            modifier = Modifier
                                .background(operatorColor),
                            textColor = Color.Yellow,
                            onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Subtract)) }
                        )
                        CalculatorButton(
                            symbol = "÷",
                            modifier = Modifier
                                .background(operatorColor),
                            textColor = Color.Yellow,
                            onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Divide)) }
                        )


                    }
                    // Row 4 ===========================
                    Row()
                    {
                        CalculatorButton(
                            symbol = "",
                            modifier = Modifier
                                .background(numberColor),
                            onClick = { }
                        )
                        CalculatorButton(
                            symbol = "0",
                            modifier = Modifier
                                .background(numberColor),
                            onClick = { onAction(CalculatorAction.Number(0)) }
                        )
                        CalculatorButton(
                            symbol = ".",
                            modifier = Modifier

                                .background(numberColor),
                            onClick = { onAction(CalculatorAction.Decimal) }
                        )
                        CalculatorButton(
                            symbol = "=",
                            modifier = Modifier
                                .background(operatorColor),
                            onClick = { onAction(CalculatorAction.Calculate) },
                            textColor = Color.Yellow
                        )

                        CalculatorButton(
                            symbol = "",
                            modifier = Modifier
                                .background(operatorColor),
                            onClick = { }
                        )

                    }
                }

            }

        }

    }
}