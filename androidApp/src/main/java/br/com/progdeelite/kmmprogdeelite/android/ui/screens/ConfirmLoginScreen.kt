package br.com.progdeelite.kmmprogdeelite.android.ui.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import br.com.progdeelite.kmmprogdeelite.android.ui.components.PrimaryButton
import br.com.progdeelite.kmmprogdeelite.android.ui.components.Spacing
import br.com.progdeelite.kmmprogdeelite.android.ui.headers.NavigationHeader
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.AndroidAppTheme
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.TextStyles
import br.com.progdeelite.kmmprogdeelite.android.utils.DependencyInjectionForPreview
import br.com.progdeelite.kmmprogdeelite.resources.Resources
import br.com.progdeelite.kmmprogdeelite.viewmodels.LoginViewModel

@Composable
fun ConfirmLoginScreen(
    navController: NavHostController? = null,
    viewModel: LoginViewModel? = null,
    onBack: () -> Unit = {},
    onClose: () -> Unit = {},
    onNext: () -> Unit = {}
) {
    val screenState = ScreenState(rememberScrollState())
    BaseScreen(
        header = {
            NavigationHeader(
                screenState = screenState,
                title = "Login Code",
                onBack = onBack,
                onClose = onClose
            )
        },
        body = {
            ConfirmLoginContent(
                scrollState = screenState.scrollState,
                onNext = onNext
            )
        }
    )
}

@Composable
fun ConfirmLoginContent(
    scrollState: ScrollState,
    onNext: (() -> Unit)? = null
) {
    val top: @Composable () -> Unit = {
        Column(
            modifier = Modifier.padding(horizontal = Resources.Dimen.screen.padding)
        ) {
            Spacing.Big()
            Text(
                text = getLoremIpsumShort(),
                style = TextStyles.body1,
                color = Resources.Theme.defaultTextColor.getColor()
            )
            Spacing.Big()
        }
    }

    val middle: @Composable () -> Unit = {
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
                Spacing.Normal()
                if (onNext != null) {
                    PrimaryButton(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        text = "Confirmar",
                        onClick = onNext,
                    )
                }
            }
        }
    }

    val bottom: @Composable () -> Unit = {
        Column(
            modifier = Modifier.padding(horizontal = Resources.Dimen.screen.padding)
        ) {
            Spacing.Big()
            Text(
                text = getLoremIpsumLong(),
                style = TextStyles.body1,
                color = Resources.Theme.defaultTextColor.getColor()
            )
            Spacing.Big()
        }
    }

    BaseScreenContent(
        scrollState = scrollState
    ) {
        top()
        middle()
        bottom()
    }
}

@Preview(showBackground = true)
@Composable
fun ConfirmLoginScreenPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        ConfirmLoginScreen()
    }
}