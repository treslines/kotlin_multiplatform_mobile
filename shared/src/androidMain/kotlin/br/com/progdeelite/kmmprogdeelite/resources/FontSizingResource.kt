package br.com.progdeelite.kmmprogdeelite.resources

import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

actual class FontSizingResource actual constructor(
    private val fontSize: Int,
    private val fontLineHeight: Int
) {
    val size: TextUnit by lazy { fontSize.sp }
    val lineHeight: TextUnit by lazy { fontLineHeight.sp }
}