package br.com.progdeelite.kmmprogdeelite.android.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.progdeelite.kmmprogdeelite.resources.Resources
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun AndroidAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = Color.Transparent
    )

    val colors = if (darkTheme) {
        darkColors(
            primary = Resources.Theme.primary.getColor(),
            primaryVariant = Resources.Theme.primaryVariant.getColor(),
            secondary = Resources.Theme.secondary.getColor()
        )
    } else {
        lightColors(
            primary = Resources.Theme.primary.getColor(),
            primaryVariant = Resources.Theme.primaryVariant.getColor(),
            secondary = Resources.Theme.secondary.getColor()
        )
    }

    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colors = colors,
        typography = typography, // Usar custom typography aqui! (definida em Type.kt)
        shapes = shapes,
        content = content
    )
}