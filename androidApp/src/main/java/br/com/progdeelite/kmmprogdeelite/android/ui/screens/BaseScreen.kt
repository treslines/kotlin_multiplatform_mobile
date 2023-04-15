package br.com.progdeelite.kmmprogdeelite.android.ui.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.progdeelite.kmmprogdeelite.android.ui.shapes.CurvedBodyContent
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.AndroidAppTheme
import br.com.progdeelite.kmmprogdeelite.android.utils.DependencyInjectionForPreview
import br.com.progdeelite.kmmprogdeelite.resources.Resources

class ScreenState(
    val scrollState: ScrollState,
    var statusBarThreshold: Float = Resources.Dimen.screen.statusBarThreshold,
    blendLimit: Float = Resources.Dimen.screen.blendLimit,
) {
    val blendValue = minOf(scrollState.value / blendLimit, 1f)
}

@Composable
fun BaseScreen(
    header: @Composable () -> Unit,
    body: @Composable () -> Unit
) {
    Box(
        modifier = Modifier.background(Color.Transparent)
    ) {
        body()
        header()
    }
}

// Vai ser usado pelo BaseScreen (Versão apenas com conteudo inferior)
@Composable
fun BaseScreenContent(
    scrollState: ScrollState,
    bottomContent: @Composable () -> Unit
) {
    val headerHeight = Resources.Dimen.header.height
    val curveInset = Resources.Dimen.screen.curveInset

    BaseScreenContentWrapper(
        scrollState = scrollState,
        curveOffset = headerHeight - curveInset
    ) {
        bottomContent()
    }
}

// Vai ser usado pelo BaseScreen (Versão com conteudo cheio - top, middle, bottom)
@Composable
fun BaseScreenContent(
    scrollState: ScrollState,
    topContent: (@Composable () -> Unit)? = null,
    middleContent: @Composable () -> Unit = { },
    bottomContent: @Composable () -> Unit
) {
    val headerHeight = Resources.Dimen.header.height
    val curveInset = Resources.Dimen.screen.curveInset
    var curveOffset by remember { mutableStateOf(headerHeight - curveInset) }
    val localDensity = LocalDensity.current

    BaseScreenContentWrapper(
        scrollState = scrollState,
        curveOffset = curveOffset
    ) {
        if (topContent != null) {
            topContent()
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = curveInset)
                .onGloballyPositioned { coordinates ->
                    curveOffset = with(localDensity) {
                        val startPositionY = coordinates.positionInParent().y.toDp()
                        // 1. try to set the lowest point of the curve at 50% of the middle content
                        // 2. if there is no middle content set offset to 0.dp (no negative offset allowed)
                        // 3. this ensures that there is always a height of at least the inset of the curve
                        val curveRelativeOffset = (coordinates.size.height.toDp() * 0.5f - curveInset).coerceAtLeast(0.dp)
                        startPositionY + curveRelativeOffset
                    }
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            middleContent()
        }
        bottomContent()
    }
}

@Composable
fun BaseScreenContentWrapper(
    scrollState: ScrollState,
    curveOffset: Dp,
    content: @Composable () -> Unit
) {
    CurvedBodyContent(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        curveOffset = curveOffset
    ) {
        Spacer(
            modifier = Modifier
                .height(Resources.Dimen.header.height)
                .fillMaxWidth()
        )
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun BaseScreenBottomContentPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        // This base screen content is used to distribute the
        // actual screen content properly along curved canvas
        BaseScreenContent(
            scrollState = ScrollState(40),
            bottomContent = { Text("Hello Bottom Content") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BaseScreenAllContentPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        // This base screen content is used to distribute the
        // actual screen content properly along curved canvas
        BaseScreenContent(
            scrollState = ScrollState(40),
            topContent = { Text("Hello Top Content") },
            middleContent = { Text("Hello Middle Content") },
            bottomContent = { Text("Hello Bottom Content") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BaseScreenContentWrapperPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        // This wrapper is needed to draw the actual
        // background of the screen with the curved canvas
        val curveHeightTopDown = 80.dp
        val curvedCanvasAnimState = ScrollState(10)
        BaseScreenContentWrapper(
            scrollState = curvedCanvasAnimState,
            curveOffset = curveHeightTopDown,
            content = { Text("Screen Content Wrapper") }
        )
    }
}