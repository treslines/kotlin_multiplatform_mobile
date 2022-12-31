package br.com.progdeelite.kmmprogdeelite.resources

import android.util.DisplayMetrics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.progdeelite.kmmprogdeelite.utils.AndroidMainApp

actual fun getWindowSize(): WindowSize {
    val dm : DisplayMetrics = AndroidMainApp.applicationContext.resources.displayMetrics
    val dpWidth = dm.widthPixels / dm.density
    return when{
        dpWidth <= WindowSize.Small.size -> WindowSize.Small
        dpWidth > WindowSize.Small.size && dpWidth <= WindowSize.Medium.size -> WindowSize.Medium
        dpWidth > WindowSize.Medium.size -> WindowSize.Large
        else -> WindowSize.Small // should never happen
    }
}

actual class SpacingResource actual constructor(private val unit: Int) {
    val dp: Dp by lazy { dp() }
    private fun dp(): Dp {
        return unit.dp
    }
}