package br.com.progdeelite.kmmprogdeelite.android.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.sp

/** Centralizes App text styles */
object TextStyles {
    val h0 = TextStyle(
        fontFamily = FontTypes.ttNormsBold.toFontFamily(),
        fontWeight = FontTypes.ttNormsBold.weight,
        fontSize = 30.sp,
        fontStyle = FontTypes.ttNormsBold.style
    )
    val h1 = TextStyle(
        fontFamily = FontTypes.ttNormsMedium.toFontFamily(),
        fontWeight = FontTypes.ttNormsMedium.weight,
        fontSize = 18.sp,
        fontStyle = FontTypes.ttNormsMedium.style
    )
    val h2 = TextStyle(
        fontFamily = FontTypes.ttNormsBold.toFontFamily(),
        fontWeight = FontTypes.ttNormsBold.weight,
        fontSize = 20.sp,
        fontStyle = FontTypes.ttNormsBold.style
    )
    val body1 = TextStyle(
        fontFamily = FontTypes.ttNormsRegular.toFontFamily(),
        fontWeight = FontTypes.ttNormsRegular.weight,
        fontSize = 20.sp,
        fontStyle = FontTypes.ttNormsRegular.style
    )
    val body2 = TextStyle(
        fontFamily = FontTypes.ttNormsBold.toFontFamily(),
        fontWeight = FontTypes.ttNormsBold.weight,
        fontSize = 18.sp,
        fontStyle = FontTypes.ttNormsBold.style
    )
    val button = TextStyle(
        fontFamily = FontTypes.ttNormsBold.toFontFamily(),
        fontWeight = FontTypes.ttNormsBold.weight,
        fontSize = 15.sp,
        fontStyle = FontTypes.ttNormsBold.style
    )
    val smallButton = TextStyle(
        fontFamily = FontTypes.ttNormsBold.toFontFamily(),
        fontWeight = FontTypes.ttNormsBold.weight,
        fontSize = 13.sp,
        fontStyle = FontTypes.ttNormsBold.style
    )
}