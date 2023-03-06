package br.com.progdeelite.kmmprogdeelite.android.ui.components

import android.content.res.Configuration
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.AndroidAppTheme
import br.com.progdeelite.kmmprogdeelite.android.utils.DependencyInjectionForPreview
import br.com.progdeelite.kmmprogdeelite.resources.Resources

// 1) COMO CRIAR UMA CURVA CONCAVE
// 2) COMO CRIAR UMA CURVA CONVEX
// 3) COMO ANIMAR UMA CURVA CONVEX EM TRANSISÕES
// 4) COMO EXIBIR NO PREVIEW

class ConcaveCanvas(private val inset: Dp): Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        // o ponto de controle precisa ter duas vezes o tamanho
        // do inset relativo ao start e pontos finais
        // para assegurar que a curva tenha exatamente
        // a altura do valor do inset devido a natureza das curvas cúbicas
        val path = Path().apply {
            moveTo(0f, 0f)
            quadraticBezierTo(size.width / 2, with(density) { inset.toPx() } * 2, size.width, 0f)
            lineTo(size.width, size.height)
            lineTo(0f, size.height)
            close()
        }
        return Outline.Generic(path)
    }
}

class ConvexCanvas(private val offset: Dp): Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
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


enum class ConcaveAnimation {
    In, Out
}

@Composable
fun AnimatedConcaveContentLayout(
    backgroundColor: Color = Resources.Theme.backgroundSecondary.getColor(),
    animation: ConcaveAnimation,
    content: @Composable () -> Unit
) {
    val defaultInset = 50.dp
    val curvedInset = animateDpAsState(
        targetValue = when (animation) {
            ConcaveAnimation.In -> defaultInset
            ConcaveAnimation.Out -> 0.dp
        },
        animationSpec = tween(150, 0, LinearOutSlowInEasing)
    )

    ConcaveContentLayout(
        backgroundColor = backgroundColor,
        curvedInset = curvedInset.value,
        content = content
    )
}

@Composable
fun ConcaveContentLayout(
    backgroundColor: Color = Resources.Theme.backgroundSecondary.getColor(),
    curvedInset: Dp = 50.dp,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .background(
                shape = ConcaveCanvas(inset = curvedInset),
                color = backgroundColor
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(curvedInset))
        content()
    }
}

@Composable
fun ConvexContentLayout(
    backgroundColor: Color = Resources.Theme.backgroundSecondary.getColor(),
    offset: Dp = 40.dp,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .background(
                shape = ConvexCanvas(offset = offset),
                color = backgroundColor
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(offset))
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
            ConcaveContentLayout(
                backgroundColor = Resources.Theme.backgroundPrimary.getColor()
            ) {
                Text(text = "Ola Ricardo")
            }
            Spacing.Normal()
            AnimatedConcaveContentLayout(
                animation = ConcaveAnimation.In
            ) {}
            Spacing.Normal()
            ConvexContentLayout(
                backgroundColor = Resources.Theme.backgroundPrimary.getColor()
            ) {
                Text(text = "Ola Ricardo")
            }
        }
    }
}