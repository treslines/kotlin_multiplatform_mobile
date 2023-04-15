package br.com.progdeelite.kmmprogdeelite.android.ui.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.progdeelite.kmmprogdeelite.android.ui.components.PrimaryButton
import br.com.progdeelite.kmmprogdeelite.android.ui.components.Spacing
import br.com.progdeelite.kmmprogdeelite.android.ui.headers.NavigationHeader
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.AndroidAppTheme
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.TextStyles
import br.com.progdeelite.kmmprogdeelite.android.utils.DependencyInjectionForPreview
import br.com.progdeelite.kmmprogdeelite.resources.Resources

@Composable
fun LoginScreen(
    onClose: () -> Unit,
    onNext: () -> Unit
) {
    val screenScrollState = ScreenState(rememberScrollState())
    BaseScreen(
        header = {
            NavigationHeader(
                screenState = screenScrollState,
                title = "Fazer Login",
                onBack = null,
                onClose = onClose
            )
        },
        body = {
            LoginContent(
                scrollState = screenScrollState.scrollState,
                onNext = onNext
            )
        }
    )
}


@Composable
fun LoginContent(
    scrollState: ScrollState,
    onNext: (() -> Unit)? = null
) {
    BaseScreenContent(
        scrollState = scrollState
    ) {
        Column(
            modifier = Modifier.padding(horizontal = Resources.Dimen.screen.padding)
        ) {
            Spacing.Big()
            Text(
                text = getLoremIpsumMedium(),
                style = TextStyles.body1,
                color = Resources.Theme.defaultTextColor.getColor()
            )
            Spacing.Big()
            if (onNext != null) {
                PrimaryButton(
                    modifier = Modifier.align(CenterHorizontally),
                    text = "Login",
                    onClick = onNext,
                )
            }
            Spacing.Big()
            Text(
                text = getLoremIpsumLong(),
                style = TextStyles.body1,
                color = Resources.Theme.defaultTextColor.getColor()
            )
        }
    }
}

@Preview
@Composable
fun LoginContentPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        LoginScreen({}, {})
    }
}