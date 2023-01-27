package br.com.progdeelite.kmmprogdeelite.android.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.AndroidAppTheme
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.TextStyles
import br.com.progdeelite.kmmprogdeelite.android.utils.DependencyInjectionForPreview
import br.com.progdeelite.kmmprogdeelite.resources.Resources

@Composable
fun TopButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit = {}) {
    OutlinedButton(modifier = modifier, onClick = onClick) {
        Text(text = text)
    }
}

@Composable
fun BottomButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit = {}) {
    Button(modifier = modifier, onClick = onClick) {
        Text(text = text)
    }
}

@Preview
@Composable
fun DialogButtonsPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        Column {
            TopButton(text = "Botão superior")
            Spacer(modifier = Modifier.height(12.dp))
            Spacer.Big()
            //SpacerNormal()
            BottomButton(text = "Botão inferior")
        }
    }
}
// 1) COMO CRIAR UM BASE BUTTON RE-USÁVEL (EXTENDER EM COMPOSE)
// 2) COMO CRIAR BOTÃO DE LANGUAGE PICKER
// 3) COMO CRIAR BOTÃO DE NAVEGACÃO
// 4) COMO CRIAR BOTÃO COM CONTURA
// 5) COMO CRIAR BOTÃO DE FECHAR DIALOGS
@Composable
fun BaseButton(
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    onClick: () -> Unit = {},
    content: @Composable RowScope.() -> Unit
) {
    Button(
        modifier = modifier.height(48.dp),
        onClick = onClick,
        colors = colors,
        contentPadding = PaddingValues(horizontal = Resources.Spacing.huge.dp),
        shape = RoundedCornerShape(48.dp),
        elevation = ButtonDefaults.elevation(0.dp)
    ) {
        content()
    }
}

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {}
) {
    BaseButton(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Resources.Theme.backgroundPrimary.getColor(),
            contentColor = Resources.Theme.contentPrimary.getColor(),
            disabledBackgroundColor = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled),
            disabledContentColor = Color.Transparent
        )
    ) {
        Text(
            text = text,
            style = TextStyles.button
        )
    }
}

@Composable
fun PrimaryWhiteButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {}
) {
    BaseButton(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Resources.Theme.backgroundSecondary.getColor(),
            contentColor = Resources.Theme.content1.getColor(),
            disabledBackgroundColor = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled),
            disabledContentColor = Color.Transparent
        )
    ) {
        Text(
            text = text,
            style = TextStyles.button
        )
    }
}

@Composable
fun PrimaryGrayButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {}
) {
    BaseButton(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Resources.Theme.primary.getColor(),
            contentColor = Resources.Theme.onPrimary.getColor(),
            disabledBackgroundColor = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled),
            disabledContentColor = Color.Transparent
        )
    ) {
        Text(
            text = text,
            style = TextStyles.button
        )
    }
}

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {}
) {
    OutlinedButton(
        modifier = modifier.height(48.dp),
        onClick = onClick,
        contentPadding = PaddingValues(horizontal = Resources.Spacing.huge.dp),
        shape = RoundedCornerShape(48.dp),
        elevation = ButtonDefaults.elevation(0.dp),
        border = BorderStroke(Resources.Spacing.extraTiny.dp, Resources.Theme.strokeSecondary.getColor()),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Resources.Theme.backgroundSecondary.getColor(),
            contentColor = Resources.Theme.contentSecondary.getColor(),
            disabledBackgroundColor = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled),
            disabledContentColor = Color.Transparent
        )
    ) {
        Text(
            text = text,
            style = TextStyles.button
        )
    }
}

@Composable
fun SmallButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {},
    showBackIcon: Boolean = false
) {
    TextButton(
        onClick = onClick,
        contentPadding = PaddingValues(horizontal = Resources.Spacing.normal.dp),
        modifier = modifier
            .height(34.dp)
            .defaultMinSize(minWidth = Resources.Spacing.huge.dp, minHeight = 1.dp),
        shape = RoundedCornerShape(34.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Resources.Theme.backgroundSecondaryAlpha.getColor(),
            contentColor = Resources.Theme.contentSecondary.getColor(),
            disabledBackgroundColor = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled),
            disabledContentColor = Color.Transparent
        )
    ) {
        if (showBackIcon) {
            Icon(
                imageVector = Icons.Filled.ArrowBackIos,
                contentDescription = null,
                tint = Resources.Theme.contentCloseButton.getColor(),
                modifier = Modifier
                    .padding(end = Resources.Spacing.tiny.dp)
                    .size(Resources.Spacing.normal.dp)
            )
        }
        Text(
            text = text,
            color = Resources.Theme.contentCloseButton.getColor(),
            style = TextStyles.smallButton,
        )
    }
}

@Composable
fun CloseButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    TextButton(
        onClick = onClick,
        contentPadding = PaddingValues(0.dp),
        modifier = modifier.size(Resources.Spacing.extraBig.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Resources.Theme.backgroundCloseButton.getColor(),
            contentColor = Resources.Theme.contentCloseButton.getColor(),
            disabledBackgroundColor = Resources.Theme.disabledBackgroundCloseButton.getColor(),
            disabledContentColor = Color.Transparent
        )
    ) {
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
    }
}


@Preview(uiMode = UI_MODE_NIGHT_NO)
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ButtonsPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        Column {
            PrimaryButton(text = "Explorar App")
            Spacer.Normal()
            PrimaryWhiteButton(text = "Descobrir App")
            Spacer.Normal()
            SmallButton(text = "BR")
            Spacer.Normal()
            SmallButton(text = "IT")
            Spacer.Normal()
            SmallButton(text = "Voltar", showBackIcon = true)
            Spacer.Normal()
            SmallButton(text = "Próximo")
            Spacer.Normal()
            SecondaryButton(text = "Atendimento")
            Spacer.Normal()
            CloseButton()
        }
    }
}