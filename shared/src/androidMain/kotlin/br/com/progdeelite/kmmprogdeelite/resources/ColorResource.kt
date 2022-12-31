package br.com.progdeelite.kmmprogdeelite.resources

import android.content.res.Configuration
import androidx.compose.ui.graphics.Color
import br.com.progdeelite.kmmprogdeelite.utils.AndroidMainApp

actual fun isSystemInDarkMode(): Boolean {
    val uiMode = AndroidMainApp.applicationContext.resources.configuration.uiMode
    return (uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
}

actual class ColorResource actual constructor(private val colorHexValue: Long): IosColor(colorHexValue) {
    fun getColor() = Color(colorHexValue)
}