package br.com.progdeelite.kmmprogdeelite.android.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import br.com.progdeelite.kmmprogdeelite.android.R

/** Centralizes app fonts, so we do not have to change each font manually in the whole app */
object FontTypes{
    val ttNormsBold: Font = Font(
        resId = R.font.tt_norms_bold_webfont,
        weight = FontWeight.W700,
        style = FontStyle.Normal,
    )
    val ttNormsMedium: Font = Font(
        resId = R.font.tt_norms_medium_webfont,
        weight = FontWeight.W700,
        style = FontStyle.Normal
    )
    val ttNormsRegular: Font = Font(
        resId = R.font.tt_norms_regular_webfont,
        weight = FontWeight.W500,
        style = FontStyle.Normal
    )
}

val LocalFonts = compositionLocalOf { FontTypes }

/** Makes fonts available in app's theme like MaterialTheme.colors... or MaterialTheme.typography... and so on */
val MaterialTheme.fonts: FontTypes
    @Composable
    @ReadOnlyComposable
    get() = LocalFonts.current