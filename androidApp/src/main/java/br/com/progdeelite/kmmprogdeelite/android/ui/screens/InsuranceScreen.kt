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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import br.com.progdeelite.kmmprogdeelite.android.ui.components.PrimaryButton
import br.com.progdeelite.kmmprogdeelite.android.ui.components.Spacing
import br.com.progdeelite.kmmprogdeelite.android.ui.headers.TopLevelHeader
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.AndroidAppTheme
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.TextStyles
import br.com.progdeelite.kmmprogdeelite.android.utils.DependencyInjectionForPreview
import br.com.progdeelite.kmmprogdeelite.navigation.Graphs
import br.com.progdeelite.kmmprogdeelite.resources.Resources

@Composable
fun InsuranceScreen(
    navController: NavHostController
) {
    InsuranceScreen(
        onInsuranceClick = { navController.navigate(Graphs.AuthLoginGraph.Login.startRoute)}
    )
}

@Composable
fun InsuranceScreen(
    onInsuranceClick: () -> Unit
) {
    val screenState = ScreenState(rememberScrollState())

    BaseScreen(
        header = {
            TopLevelHeader(
                screenState = screenState,
                title = "Seguros"
            )
        },
        body = {
            InsuranceContent(
                scrollState = screenState.scrollState,
                onInsuranceClick = onInsuranceClick
            )
        }
    )
}

@Composable
fun InsuranceContent(
    scrollState: ScrollState,
    onInsuranceClick: () -> Unit
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
                    .padding(horizontal = Resources.Dimen.screen.padding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacing.Big()
                PrimaryButton(text = "Contratar", onClick = onInsuranceClick)
                Spacing.Big()
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun InsuranceScreenPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        InsuranceScreen {}
    }
}