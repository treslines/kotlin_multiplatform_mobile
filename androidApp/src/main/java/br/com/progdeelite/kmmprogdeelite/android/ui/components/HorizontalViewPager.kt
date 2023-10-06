package br.com.progdeelite.kmmprogdeelite.android.ui.components


import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import br.com.progdeelite.kmmprogdeelite.android.R
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.AndroidAppTheme
import br.com.progdeelite.kmmprogdeelite.android.utils.DependencyInjectionForPreview
import br.com.progdeelite.kmmprogdeelite.resources.Resources


// 0) quais dependencias adicionar
// 1) como criar view pager reutilizável em compose
// 2) como usar isso a seu favor em entrevistas

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun <T> HorizontalViewPager(
    initialPage: Int = 0, // para poder voltar para conteudo exibido
    items: List<T> = emptyList(), // itens a serem exibidos
    beyondBoundsPageCount: Int = 3, // quantas paginas pre-load
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    content: @Composable (T) -> Unit // layout onde o conteudo será exibido
) {
    Column(modifier = Modifier.wrapContentSize()) {
        val pagerState = rememberPagerState(
            initialPage = if (initialPage < items.size) initialPage else 0
        )

        LaunchedEffect(initialPage) {
            if (pagerState.currentPage != initialPage) {
                pagerState.scrollToPage(initialPage)
            }
        }

        HorizontalPager(
            verticalAlignment = verticalAlignment,
            pageCount = items.size,
            beyondBoundsPageCount = beyondBoundsPageCount,
            state = pagerState
        ) {
            content(items[it])
        }
        // indicadores do view pager
        Row(
            Modifier
                .padding(
                    top = Resources.Dimen.viewPager.indicatorComponentPadding
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            if(items.size > 1) { // so exibir se mais do que 1
                repeat(items.size) { page ->
                    val color = if (pagerState.currentPage == page) Resources.Theme.secondary.getColor() else Resources.Theme.background.getColor()
                    Box(
                        modifier = Modifier
                            .padding(Resources.Dimen.viewPager.indicatorPadding)
                            .clip(CircleShape)
                            .background(color)
                            .size(Resources.Dimen.viewPager.indicatorSize)
                    )
                }
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
fun HorizontalViewPagerPreview() {
    DependencyInjectionForPreview()

    data class Item(
        val imageId: Int,
        val statusTextColor: Color,
        val statusTextBgColor: Color,
        val isActive: Boolean,
        val statusText: String,
        val actionText: String,
        val entries: List<Pair<String,String>>,
        val action: () -> Unit
    )

    val items = listOf(
        Item(
            imageId = R.drawable.info,
            statusTextColor = Resources.Theme.badgeActiveText.getColor(),
            statusTextBgColor = Resources.Theme.badgeActiveBg.getColor(),
            isActive = false,
            statusText = "Ativo",
            actionText = "Compartilhar",
            entries = listOf(
                Pair("Kilometers", "10km"),
                Pair("Altitude", "1580m"),
                Pair("Calorias", "250kJ"),
                Pair("Tempo", "1h 32m"),
            ),
            action = {}
        ),
        Item(
            imageId = R.drawable.info,
            statusTextColor = Resources.Theme.badgeActiveText.getColor(),
            statusTextBgColor = Resources.Theme.badgeActiveBg.getColor(),
            isActive = false,
            statusText = "Inativo",
            actionText = "Iniciar Corrida",
            entries = listOf(
                Pair("Kilometers", "0km"),
                Pair("Altitude", "0m"),
                Pair("Calorias", "0kJ"),
                Pair("Tempo", "00:00"),
            ),
            action = {}
        ),
        Item(
            imageId = R.drawable.info,
            statusTextColor = Resources.Theme.badgeActiveText.getColor(),
            statusTextBgColor = Resources.Theme.badgeActiveBg.getColor(),
            isActive = false,
            statusText = "Bloqueado",
            actionText = "Desbloqueiar",
            entries = listOf(
                Pair("Kilometers", "0km"),
                Pair("Altitude", "0m"),
                Pair("Calorias", "0kJ"),
                Pair("Tempo", "00:00"),
            ),
            action = {}
        )
    )
    AndroidAppTheme {
        HorizontalViewPager(items = items) {
            ViewPagerComponent(
                imageId = it.imageId,
                statusTextColor = it.statusTextColor,
                statusTextBgColor = it.statusTextBgColor,
                isActive = it.isActive,
                statusText = it.statusText,
                actionText = it.actionText,
                entries = it.entries,
                action = it.action
            )
        }
    }
}

