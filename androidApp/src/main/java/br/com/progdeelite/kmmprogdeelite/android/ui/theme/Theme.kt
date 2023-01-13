package br.com.progdeelite.kmmprogdeelite.android.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.progdeelite.kmmprogdeelite.resources.Resources

@Composable
fun AndroidAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) {
        darkColors(
            primary = Resources.Dark.primary.getColor(),
            primaryVariant = Resources.Dark.primaryVariant.getColor(),
            secondary = Resources.Dark.secondary.getColor()
        )
    } else {
        lightColors(
            primary = Resources.Light.primary.getColor(),
            primaryVariant = Resources.Light.primaryVariant.getColor(),
            secondary = Resources.Light.secondary.getColor()
        )
    }
    val typography = Typography(
        body1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )
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