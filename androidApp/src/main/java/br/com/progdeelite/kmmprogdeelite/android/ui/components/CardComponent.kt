package br.com.progdeelite.kmmprogdeelite.android.ui.components

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.progdeelite.kmmprogdeelite.android.R
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.AndroidAppTheme
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.TextStyles
import br.com.progdeelite.kmmprogdeelite.android.utils.DependencyInjectionForPreview
import br.com.progdeelite.kmmprogdeelite.resources.Resources

// 1) como criar um componente de card reutilizável
// 2) como criar um conteúdo bonito pra te destacar em entrevistas
// 3) como exibir tipos de cards diferentes dependendo do estado

@Composable
fun CardBackground(
    fullWidth: Boolean? = false,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = if (fullWidth == false) Resources.Dimen.card.padding else 0.dp)
            .clip(shape = RoundedCornerShape(size = Resources.Dimen.card.cornerRadius))
            .background(color = Resources.Theme.primary.getColor())
    ) {
        content()
    }
}


@Composable
fun ViewPagerComponent(
    @DrawableRes imageId: Int,
    statusTextColor: Color,
    statusTextBgColor: Color,
    isActive: Boolean,
    statusText: String,
    actionText: String,
    entries: List<Pair<String,String>>,
    action: () -> Unit = {}
) {
    CardBackground {
        Column(
            modifier = Modifier
                .background(color = Resources.Theme.background1.getColor())
                .padding(
                    horizontal = Resources.Spacing.large.dp,
                    vertical = Resources.Spacing.large.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = null,
                modifier = Modifier
                    .defaultMinSize(
                        minWidth = Resources.Dimen.card.width,
                        minHeight = Resources.Dimen.card.height
                    )
                    .align(Alignment.CenterHorizontally)
                    .size(
                        width = Resources.Dimen.card.width,
                        height = Resources.Dimen.card.height
                    )
            )
            Spacing.Big()
            Column(
                modifier = Modifier
                    .background(
                        color = statusTextBgColor,
                        shape = RoundedCornerShape(size = Resources.Dimen.card.cornerRadius)
                    )
            ) {
                AccessibilityText(
                    modifier = Modifier.padding(
                        start = Resources.Spacing.small.dp,
                        top = Resources.Spacing.tiny.dp,
                        bottom = Resources.Spacing.tiny.dp,
                        end = Resources.Spacing.small.dp
                    ),
                    text = statusText.toUpperCase(Locale.current),
                    maxLines = 1,
                    style = TextStyles.description,
                    color = statusTextColor
                )
            }
            Spacing.Big()
            Divider(
                modifier = Modifier.padding(
                    start = Resources.Dimen.defaultPadding.start,
                    end = Resources.Dimen.defaultPadding.end
                ),
                color = Resources.Theme.divider.getColor()
            )
            Spacing.Big()
            AccessibilityText(
                text = getTitle(entries, 0),
                maxLines = 1,
                textAlign = TextAlign.Center,
                style = TextStyles.h3,
                color = if (isActive) Resources.Theme.secondary.getColor() else Resources.Theme.secondaryVariant.getColor()
            )
            Spacing.Tiny()
            AccessibilityText(
                text = getSubtitle(entries, 0),
                maxLines = 1,
                textAlign = TextAlign.Center,
                style = TextStyles.h2,
                color = if (isActive) Resources.Theme.textPlaceholder.getColor() else Resources.Theme.textDefault.getColor()
            )
            Spacing.Medium()
            AccessibilityText(
                text = getTitle(entries, 1),
                maxLines = 1,
                textAlign = TextAlign.Center,
                style = TextStyles.h3,
                color = if (isActive) Resources.Theme.textDisabled.getColor() else Resources.Theme.textMuted.getColor()
            )
            Spacing.Tiny()
            AccessibilityText(
                text = getSubtitle(entries, 1),
                maxLines = 1,
                textAlign = TextAlign.Center,
                style = TextStyles.h2,
                color = if (isActive) Resources.Theme.textPlaceholder.getColor() else Resources.Theme.textDefault.getColor()
            )
            Spacing.Medium()
            AccessibilityText(
                text = getTitle(entries, 2),
                maxLines = 1,
                textAlign = TextAlign.Center,
                style = TextStyles.button,
                color = if (isActive) Resources.Theme.textDisabled.getColor() else Resources.Theme.textMuted.getColor()
            )
            Spacing.Tiny()
            AccessibilityText(
                text = getSubtitle(entries, 2),
                maxLines = 1,
                textAlign = TextAlign.Center,
                style = TextStyles.body1,
                color = if (isActive) Resources.Theme.textPlaceholder.getColor() else Resources.Theme.textMuted.getColor()
            )
            Spacing.Big()
            PrimaryButton(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = actionText, onClick = action
            )
        }
    }
}

@Composable
private fun getTitle(entries: List<Pair<String,String>>, index: Int) = if (entries.isNotEmpty()) entries[index].first else "-"
@Composable
private fun getSubtitle(entries: List<Pair<String,String>>, index: Int) = if (entries.isNotEmpty()) entries[index].second else "-"

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CardComponentPreview() {
    DependencyInjectionForPreview()

    AndroidAppTheme {
        ViewPagerComponent(
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
        )
    }
}