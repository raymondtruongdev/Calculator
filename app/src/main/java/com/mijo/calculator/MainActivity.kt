package com.mijo.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mijo.calculator.ui.theme.bgColor
import com.mijo.calculator.util.LogUtils


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            CalculatorTheme {
            val size = Size()
            val screenHeight = size.height()
            val screenWidth = size.width()
            LogUtils.e("height = $screenHeight, with = $screenWidth")

            val viewModel = viewModel<CalculatorViewModel>()
            val state = viewModel.state
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color.Black)
            ) {
                Calculator(
                    state = state,
                    onAction = viewModel::onAction,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(bgColor)
                )
            }

        }
    }
}


