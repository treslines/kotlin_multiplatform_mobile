package br.com.progdeelite.kmmprogdeelite.android.ui.headers

// Video 0 - Conceito Header - Intro com Gráfico Didático
//      Elaboração do conceito do header
//      Camadas para exibição do header
//      Como cobrir todos so casos de uso
//      Como desenhar no meio da curva
//      Como animar fade, blur e statusbar
//      Como criar headers e screens reutilizáveis

// Video 1 - Infraestrutura, SetUp
//      dependências accompanist, Compose 1.2.1
//      colors.xml
//      app_gradient_bg.xml, style.xml (background, statusbar)
//      TextStyle, Thema (classe),
//      assets navegação
//      CorerResource, DimenResource,

// Video 2 - Conteúdo
//      Botões (templates)
//      Compensação bottom navigation (se nao poder usar accompanist)
//      Shapes (curvas côncavas e convex)
//      Conteudo em curvas

// Video 3 - HeaderOverlay
//      MainActivity (setDecorFitsSystemWindows, Modifier.navigationBarsPadding())
//      HeaderOverlay (detalhes scroll, animação, fakeBlur e status bar change)
//      ActionHeader (header que prevê ações)
//      NavigationHeader (header de navegação)

// Video 4 - BaseScreen e UiState
//      BaseScreen
//      BaseScreenContent (detalhes do scroll state)
//      BaseScreenContentWrapper (para desenhar curva na posição desejada - vide gráfico)

// Video 5 - Criar Telas (screens) concretas
//      LoginScreen (usando uiState, conteudo bottom)
//      HomeScreen (usando uiState, conteudo middle, bottom)
//      SupportContent (usando uiState, conteudo middle, bottom)
//      Confirm2faScreen (usando conteudo top, middle, bottom)
//      ProfileScreen (usando conteudo top, middle, bottom)
//      RootNavigationGraph (usar as screens criadas)


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.graphics.ColorUtils
import br.com.progdeelite.kmmprogdeelite.android.ui.components.BackIconButton
import br.com.progdeelite.kmmprogdeelite.android.ui.components.CloseIconButton
import br.com.progdeelite.kmmprogdeelite.android.ui.components.PlaceholderIconButton
import br.com.progdeelite.kmmprogdeelite.android.ui.components.Spacing
import br.com.progdeelite.kmmprogdeelite.android.ui.screens.ScreenState
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.AndroidAppTheme
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.TextStyles
import br.com.progdeelite.kmmprogdeelite.android.utils.DependencyInjectionForPreview
import br.com.progdeelite.kmmprogdeelite.resources.Resources

@Composable
fun NavigationHeader(
    modifier: Modifier = Modifier,
    screenState: ScreenState,
    title: String,
    onBack: (() -> Unit)? = null,
    onClose: (() -> Unit)? = null
) {
    HeaderOverlay(
        modifier = modifier,
        scrollBlendValue = screenState.blendValue,
        statusBarThreshold = screenState.statusBarThreshold
    ) {
        NavigationHeaderContent(
            scrollBlendValue = screenState.blendValue,
            title = title,
            onLeft = onBack,
            onRight = onClose
        )
    }
}

@Composable
fun NavigationHeaderContent(
    scrollBlendValue: Float,
    title: String,
    textColorDefault: Color = Resources.Theme.textStartColor.getColor(),
    textColorScroll: Color = Resources.Theme.textEndColor.getColor(),
    buttonColorDefault: Color = Resources.Theme.btnBgWhiteAlpha.getColor(),
    buttonColorScroll: Color = Resources.Theme.btnBgGrayAlpha.getColor(),
    onLeft: (() -> Unit)?,
    onRight: (() -> Unit)?
) {
    val textColor = Color(ColorUtils.blendARGB(textColorDefault.toArgb(), textColorScroll.toArgb(), scrollBlendValue))
    val buttonColor = Color(ColorUtils.blendARGB(buttonColorDefault.toArgb(), buttonColorScroll.toArgb(), scrollBlendValue))

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        if (onLeft == null) {
            PlaceholderIconButton()
        } else {
            BackIconButton(onClick = onLeft, backgroundColor = buttonColor)
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = title,
            style = TextStyles.h1,
            color = textColor
        )
        Spacer(modifier = Modifier.weight(1f))
        if (onRight == null) {
            PlaceholderIconButton()
        } else {
            CloseIconButton(onClick = onRight, backgroundColor = buttonColor)
        }
    }
}

@Preview
@Composable
fun NavigationHeaderColorPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        Column {
            NavigationHeader(
                screenState = ScreenState(rememberScrollState(0)),
                title = "Olá Mario",
                onBack = {},
                onClose = {}
            )
            Spacing.Big()
            NavigationHeader(
                screenState = ScreenState(rememberScrollState(50)),
                title = "Olá Mario",
                onBack = {},
                onClose = {}
            )
            Spacing.Big()
            NavigationHeader(
                screenState = ScreenState(rememberScrollState(100)),
                title = "Olá Mario",
                onBack = {},
                onClose = {}
            )
        }
    }
}

@Preview
@Composable
fun NavigationHeaderLayoutPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        Column {
            val state = ScreenState(rememberScrollState(100))
            NavigationHeader(
                screenState = state,
                title = "Olá Mario",
                onBack = null,
                onClose = null
            )
            Spacing.Big()
            NavigationHeader(
                screenState = state,
                title = "Olá Mario",
                onBack = {},
                onClose = null
            )
            Spacing.Big()
            NavigationHeader(
                screenState = state,
                title = "Olá Mario",
                onBack = null,
                onClose = {}
            )
            Spacing.Big()
            NavigationHeader(
                screenState = state,
                title = "Olá Mario",
                onBack = {},
                onClose = {}
            )
        }
    }
}