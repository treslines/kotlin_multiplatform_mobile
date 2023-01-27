package br.com.progdeelite.kmmprogdeelite.android.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.progdeelite.kmmprogdeelite.resources.Resources

fun Modifier.applyDefaultListViewItemModifier(
    onItemClick: () -> Unit,
    shape: RoundedCornerShape = RoundedCornerShape(0.dp),
    backgroundColor: Color = Resources.Theme.background.getColor()
): Modifier {
    return this
        .fillMaxWidth()
        .clip(shape)
        .clickable { onItemClick() }
        .background(backgroundColor)
        .padding(12.dp)
}