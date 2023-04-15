package br.com.progdeelite.kmmprogdeelite.android.ui.headers

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils
import br.com.progdeelite.kmmprogdeelite.android.ui.components.SmallButton
import br.com.progdeelite.kmmprogdeelite.android.ui.components.Spacing
import br.com.progdeelite.kmmprogdeelite.android.ui.screens.ScreenState
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.AndroidAppTheme
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.TextStyles
import br.com.progdeelite.kmmprogdeelite.android.utils.DependencyInjectionForPreview
import br.com.progdeelite.kmmprogdeelite.resources.Resources

@Composable
fun TopLevelHeader(
    modifier: Modifier = Modifier,
    screenState: ScreenState,
    title: String,
    buttons: @Composable () -> Unit = {}
) {
    HeaderOverlay(
        modifier = modifier,
        scrollBlendValue = screenState.blendValue,
        statusBarThreshold = screenState.statusBarThreshold
    ) {
        TopLevelHeaderContent(
            scrollBlendValue = screenState.blendValue,
            title = title,
            buttons = buttons
        )
    }
}

@Composable
fun TopLevelHeaderContent(
    scrollBlendValue: Float,
    title: String,
    buttons: @Composable () -> Unit,
    textStartColor: Color = Resources.Theme.textStartColor.getColor(),
    textEndColor: Color = Resources.Theme.textEndColor.getColor()
) {
    val textColor = Color(ColorUtils.blendARGB(textStartColor.toArgb(), textEndColor.toArgb(), scrollBlendValue))

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = title,
            style = TextStyles.h2,
            color = textColor
        )
        Spacer(modifier = Modifier.weight(1f))
        buttons()
    }
}

@Preview
@Composable
fun TopLevelHeaderPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        Column {
            TopLevelHeader(
                screenState = ScreenState(rememberScrollState(0)),
                title = "Olá Mario",
                buttons = {}
            )
            Spacing.Big()
            TopLevelHeader(
                screenState = ScreenState(rememberScrollState(50)),
                title = "Olá Mario",
                buttons = {}
            )
            Spacing.Big()
            TopLevelHeader(
                screenState = ScreenState(rememberScrollState(100)),
                title = "Olá Mario",
                buttons = {}
            )
        }
    }
}

@Preview
@Composable
fun TopLeveHeaderContentPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        val visible = 0f
        val halfVisible = 0.5f
        val invisible = 1f
        Column {
            TopLevelHeaderContent(
                scrollBlendValue = visible,
                title = "Olá Mario",
                buttons = {
                    SmallButton(text = "Login")
                    Spacer(modifier = Modifier.width(10.dp))
                    SmallButton(text = "Profile")
                }
            )
            Spacing.Big()
            TopLevelHeaderContent(
                scrollBlendValue = halfVisible,
                title = "Olá Mario",
                buttons = {
                    SmallButton(text = "Login")
                    Spacer(modifier = Modifier.width(10.dp))
                    SmallButton(text = "Profile")
                }
            )
            Spacing.Big()
            TopLevelHeaderContent(
                scrollBlendValue = invisible,
                title = "Olá Mario",
                buttons = {
                    SmallButton(text = "Login")
                    Spacer(modifier = Modifier.width(10.dp))
                    SmallButton(text = "Profile")
                }
            )
        }
    }
}