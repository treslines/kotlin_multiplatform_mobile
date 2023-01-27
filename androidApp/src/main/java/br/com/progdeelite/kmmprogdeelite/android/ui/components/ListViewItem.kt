package br.com.progdeelite.kmmprogdeelite.android.ui.components

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.AndroidAppTheme
import br.com.progdeelite.kmmprogdeelite.android.utils.DependencyInjectionForPreview
import br.com.progdeelite.kmmprogdeelite.android.utils.applyDefaultListViewItemModifier
import br.com.progdeelite.kmmprogdeelite.android.R


// 1) COMO CRIAR LIST ITEM REUSÁVEL EM COMPOSE
// 2) COMO CRIAR UM CUSTOM MODIFIER REUSÁVEL
// 3) COMO USAR O RECURSO DE COR COMPARTILHADO EM KMM

/**
 * Reusable List view Item
 * @param modifier optional item row modifier
 * @param title mandatory item description
 * @param subtitle optional item subtitle
 * @param image optional item image on the right
 * @param imageContentDescription optional item image content description
 * @param imageModifier optional item image modifier
 * @param onItemClick optional on item click action
 */
@Composable
@SuppressLint("ModifierParameter")
fun ListViewItem(
    modifier: Modifier? = null,
    title: String,
    subtitle: String? = null,
    @DrawableRes image: Int? = null,
    @StringRes imageContentDescription: Int? = null,
    imageModifier: Modifier = Modifier,
    onItemClick: () -> Unit = {},
) {
    Row(
        modifier = modifier ?: Modifier.applyDefaultListViewItemModifier(onItemClick),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = title, style = MaterialTheme.typography.h6)
            subtitle?.let {
                Text(text = it, style = MaterialTheme.typography.subtitle1)
            }
        }
        image?.let { imageId ->
            Image(
                painter = painterResource(id = imageId),
                contentDescription = if (imageContentDescription != null) stringResource(id = imageContentDescription) else null,
                modifier = imageModifier.size(48.dp),
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewListViewItemWithoutImage() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        ListViewItem(
            title = "Sample title"
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewListViewItemWithImage() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        ListViewItem(
            title = "Sample title",
            image = R.drawable.ic_warning
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewListViewItemWithImageSubtitle() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        ListViewItem(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(Color.Cyan)
                .padding(15.dp),
            title = "Sample title",
            subtitle = "Sample Subtitle",
            image = R.drawable.ic_warning,
            imageModifier = Modifier.clip(RoundedCornerShape(60.dp))
        )
    }
}