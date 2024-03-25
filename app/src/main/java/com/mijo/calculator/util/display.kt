package com.mijo.calculator.util

import android.content.Context
import android.util.DisplayMetrics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


fun Context.pxToDp(px: Float): Dp {
    val densityDpi = resources.displayMetrics.densityDpi
//    return (px / (densityDpi / 160f)).dp
    return (px / (densityDpi / DisplayMetrics.DENSITY_DEFAULT)).dp
}


/**
 * This method converts device specific pixels to density independent pixels.
 *
 * @param px A value in px (pixels) unit. Which we need to convert into db
 * @param context Context to get resources and device specific display metrics
 * @return A float value to represent dp equivalent to px value
 */
fun convertPixelsToDp(px: Float, context: Context): Float {
    return px / (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
}