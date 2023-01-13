package br.com.progdeelite.kmmprogdeelite.android.ui.theme


import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import br.com.progdeelite.kmmprogdeelite.resources.Resources

// 1) Criar classe de spacing
// 2) usar recurso de spacing
// 3) disponibilizar no material theme

/** Centralizes app spacings, so we do not have to change each spacing manually in the whole app */
data class Spacing(
    val noSpace: Dp = Resources.Spacing.noSpace.dp,
    val tiny: Dp = Resources.Spacing.tiny.dp,
    val extraSmall: Dp = Resources.Spacing.extraSmall.dp,
    val small: Dp = Resources.Spacing.small.dp,
    val extraTiny: Dp = Resources.Spacing.extraTiny.dp,
    val normal: Dp = Resources.Spacing.normal.dp,
    val medium: Dp = Resources.Spacing.medium.dp,
    val big: Dp = Resources.Spacing.big.dp,
    val extraBig: Dp = Resources.Spacing.extraBig.dp,
    val large: Dp = Resources.Spacing.large.dp,
    val extraLarge: Dp = Resources.Spacing.extraLarge.dp,
    val huge: Dp = Resources.Spacing.huge.dp,
    val extraHuge: Dp = Resources.Spacing.extraHuge.dp,
)

val LocalSpacing = compositionLocalOf { Spacing() }

/** Makes spacing available in app's theme like MaterialTheme.colors... or MaterialTheme.typography... and so on */
val MaterialTheme.spacing: Spacing
    @Composable
    @ReadOnlyComposable
    get() = LocalSpacing.current

