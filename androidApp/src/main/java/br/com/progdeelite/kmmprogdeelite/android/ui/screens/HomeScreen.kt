package br.com.progdeelite.kmmprogdeelite.android.ui.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.graphics.ColorUtils
import androidx.navigation.NavHostController
import br.com.progdeelite.kmmprogdeelite.android.ui.components.Spacing
import br.com.progdeelite.kmmprogdeelite.android.ui.headers.TopLevelHeader
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.AndroidAppTheme
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.TextStyles
import br.com.progdeelite.kmmprogdeelite.android.utils.DependencyInjectionForPreview
import br.com.progdeelite.kmmprogdeelite.resources.Resources

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    HomeScreen(
        onLoginClick = { },
        onProfileClick = { }
    )
}

@Composable
fun HomeScreen(
    onLoginClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    val screenState = ScreenState(rememberScrollState())

    val textColor = Color(
        ColorUtils.blendARGB(
            Color.White.toArgb(),
            Resources.Theme.textEndColor.getColor().toArgb(),
            screenState.blendValue
        )
    )

    BaseScreen(
        header = {
            TopLevelHeader(
                screenState = screenState,
                title = "Home",
                buttons = {
                    TextButton(onClick = onLoginClick) {
                        Text(text = "Login", color = textColor)
                    }
                    TextButton(onClick = onProfileClick) {
                        Text(text = "Perfil", color = textColor)
                    }
                }
            )
        },
        body = {
            HomeContent(
                scrollState = screenState.scrollState
            )
        }
    )
}

@Composable
fun HomeContent(
    scrollState: ScrollState
) {
    BaseScreenContent(
        scrollState = scrollState,
        middleContent = {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Resources.Dimen.screen.padding)
                    .clip(shape = RoundedCornerShape(size = Resources.Dimen.card.cornerRadius))
                    .background(color = Resources.Theme.surface.getColor())
                    .padding(all = Resources.Dimen.card.padding)
            ) {
                Column {
                    Text(
                        text = getLoremIpsumShort(),
                        style = TextStyles.body1,
                        color = Resources.Theme.defaultTextColor.getColor()
                    )
                }
            }
        },
        bottomContent = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = Resources.Dimen.screen.padding)
            ) {
                Spacing.Big()
                Text(
                    text = getLoremIpsumLong(),
                    style = TextStyles.body1,
                    color = Resources.Theme.defaultTextColor.getColor()
                )
                Spacing.Big()
                Text(
                    text = getLoremIpsumLong(),
                    style = TextStyles.body1,
                    color = Resources.Theme.defaultTextColor.getColor()
                )
                Spacing.Big()
                Text(
                    text = getLoremIpsumLong(),
                    style = TextStyles.body1,
                    color = Resources.Theme.defaultTextColor.getColor()
                )
            }
        }
    )
}

fun getLoremIpsumLong(): String {
    return "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
}

fun getLoremIpsumShort(): String {
    return "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham"
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        HomeScreen({}, {})
    }
}