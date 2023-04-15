package br.com.progdeelite.kmmprogdeelite.android.ui.headers

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.graphics.ColorUtils
import br.com.progdeelite.kmmprogdeelite.android.ui.components.Spacing
import br.com.progdeelite.kmmprogdeelite.android.ui.shapes.CurvedHeaderContent
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.AndroidAppTheme
import br.com.progdeelite.kmmprogdeelite.android.utils.DependencyInjectionForPreview
import br.com.progdeelite.kmmprogdeelite.resources.Resources
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun HeaderOverlay(
    modifier: Modifier = Modifier,
    scrollBlendValue: Float,
    statusBarThreshold: Float,
    bgColorDefault: Color = Resources.Theme.bgOverlayHeaderDefault.getColor(),
    bgColorScroll: Color = Resources.Theme.bgOverlayHeaderScroll.getColor().copy(alpha = Resources.Dimen.header.fakeBlurAlpha),
    content: @Composable () -> Unit
) {
    val bgColor = Color(ColorUtils.blendARGB(bgColorDefault.toArgb(), bgColorScroll.toArgb(), scrollBlendValue))

    val systemUiController = rememberSystemUiController()
    systemUiController.statusBarDarkContentEnabled = scrollBlendValue >= statusBarThreshold

    CurvedHeaderContent(
        modifier = Modifier.height(Resources.Dimen.header.height),
        backgroundColor = bgColor
    ) {
        Column(
            modifier = modifier
                .padding(
                    start = Resources.Dimen.header.paddingStart,
                    top = Resources.Dimen.header.paddingTop,
                    end = Resources.Dimen.header.paddingEnd,
                    bottom = Resources.Dimen.header.paddingBottom
                )
        ) {
            Spacer(modifier = Modifier.weight(weight = 1f, fill = true))
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StickyHeaderPreview() {
    DependencyInjectionForPreview()

    AndroidAppTheme {
        Column {
            HeaderOverlay(
                scrollBlendValue = 1f,
                statusBarThreshold = 1f
            ) {
                Text("Overlay Header contetext")
                Text("Overlay Header contetext")
                Text("Overlay Header contetext")
            }
            Spacing.Normal()
            HeaderOverlay(
                scrollBlendValue = 0.5f,
                statusBarThreshold = 0.5f
            ) {
                Text("Overlay Header contetext")
                Text("Overlay Header contetext")
                Text("Overlay Header contetext")
            }
            Spacing.Normal()
            HeaderOverlay(
                scrollBlendValue = 0.1f,
                statusBarThreshold = 0.1f
            ) {
                Text("Overlay Header contetext")
                Text("Overlay Header contetext")
                Text("Overlay Header contetext")
            }
            Spacing.Normal()
        }
    }
}