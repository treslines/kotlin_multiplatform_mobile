package br.com.progdeelite.kmmprogdeelite.android.ui.shapes

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import br.com.progdeelite.kmmprogdeelite.android.ui.components.Spacing
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.AndroidAppTheme
import br.com.progdeelite.kmmprogdeelite.android.utils.DependencyInjectionForPreview
import br.com.progdeelite.kmmprogdeelite.resources.Resources

class CurvedConcaveCanvas(
    private val inset: Dp,
    private val offset: Dp
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        // the control point needs to have twice the inset relative to start- and endpoints
        // to ensure that the curve has exactly the height of the "inset" value,
        // due to the nature of cubic curves
        val path = Path().apply {
            moveTo(0f, with(density) { offset.toPx() })
            quadraticBezierTo(size.width / 2, with(density) { offset.toPx() + inset.toPx() * 2 }, size.width, with(density) { offset.toPx() })
            lineTo(size.width, size.height)
            lineTo(0f, size.height)
            close()
        }
        return Outline.Generic(path)
    }
}

class CurvedConvexCanvas(private val offset: Dp) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        // the control point needs to have twice the offset relative to start- and endpoints
        // to ensure that the curve has exactly the height of the "offset" value,
        // due to the nature of cubic curves
        val offsetPx = with(density) { offset.toPx() }
        val path = Path().apply {
            moveTo(0f, 0f)
            lineTo(size.width, 0f)
            lineTo(size.width, size.height - offsetPx)
            quadraticBezierTo(size.width / 2, size.height + offsetPx, 0f, size.height - offsetPx)
            close()
        }
        return Outline.Generic(path)
    }
}

@Composable
fun CurvedBodyContent(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Resources.Theme.background.getColor(),
    curvedInset: Dp = Resources.Dimen.screen.curveInset,
    curveOffset: Dp = 0.dp,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .background(
                shape = CurvedConcaveCanvas(inset = curvedInset, offset = curveOffset),
                color = backgroundColor
            )
            .padding(top = if (curveOffset > 0.dp) 0.dp else curvedInset),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        content()
    }
}

@Composable
fun CurvedHeaderContent(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Transparent,
    curvedOffset: Dp = Resources.Dimen.screen.curveInset,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .background(
                shape = CurvedConvexCanvas(offset = curvedOffset),
                color = backgroundColor
            )
            .padding(bottom = curvedOffset),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        content()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CanvasPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        Column {
            CurvedBodyContent(
                curvedInset = 20.dp,
                curveOffset = 0.dp,
                backgroundColor = Resources.Theme.backgroundPrimary.getColor()
            ) {
                Spacing.Big()
                Text("Body Content")
            }
            Spacing.Normal()
            CurvedHeaderContent(
                curvedOffset = 20.dp,
                backgroundColor = Resources.Theme.backgroundPrimary.getColor()
            ) {
                Spacing.Big()
                Text("Head Content")
            }
        }
    }
}