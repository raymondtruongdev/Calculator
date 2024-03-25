package com.mijo.calculator

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButton(
    symbol: String,
    modifier: Modifier,
    onClick: () -> Unit,
    textColor: Color = Color.White,
    icon: ImageVector? = null // Use fully qualified name here
) {
    val buttonWidth = (Size().width() / 5) // Assuming Size() is available
    val buttonHeight = (Size().width() / 7) // Assuming Size() is available
    val ratio = Size().ratio()
    Box(
        modifier = Modifier
            .clickable { onClick() }
            .border(width = 0.2.dp, color = Color.Black)
            .height(buttonHeight.dp)
            .width(buttonWidth.dp)
            .then(modifier)
    ) {
        if (icon != null) {
            Icon(
                icon,
                contentDescription = "Clear Icon",
                tint = textColor,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size((45 * ratio).dp)
            )
        } else {
            Text(
                text = symbol,
                fontSize = (45 * ratio).sp,
                color = textColor,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

