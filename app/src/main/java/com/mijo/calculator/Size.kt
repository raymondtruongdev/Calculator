package com.mijo.calculator

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

class Size {
    @Composable
    fun height(): Int {
        val configuration = LocalConfiguration.current
        return configuration.screenHeightDp
    }

    @Composable
    fun width(): Int {
        val configuration = LocalConfiguration.current
        return configuration.screenWidthDp
    }

    @Composable
    fun ratio(): Double {
        val configuration = LocalConfiguration.current
        val ratio = configuration.screenWidthDp / 480.0
        return ratio
    }


}