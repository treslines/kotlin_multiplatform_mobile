package br.com.progdeelite.kmmprogdeelite.android.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.AndroidAppTheme
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.TextStyles
import br.com.progdeelite.kmmprogdeelite.android.utils.DependencyInjectionForPreview
import br.com.progdeelite.kmmprogdeelite.localization.DialogTexts
import br.com.progdeelite.kmmprogdeelite.resources.Resources

// 1) COMO CRIAR ALERT DIALOGS EM KMM COMPARTILHANDO TEXTO (DIALOG TEXTS)
// 2) ATUALIZAR StringResources, string.xml, DimensResource, ColorResource
// 3) CRIAR CAIXINHAS DE ALERTA, CUSTOM DIALOGS OU POPUPS
// 4) COMO USAR NA PRÁTICA NA MAIN ACTIVITY

@Composable
fun CustomDialog(
    dialogTexts: DialogTexts,
    primaryButtonAction: () -> Unit,
    secondaryButtonAction: (() -> Unit)? = null
) {
    CustomDialog(
        title = dialogTexts.title.localized,
        description = dialogTexts.description.localized,
        primaryText = dialogTexts.primaryButtonText.localized,
        primaryAction = primaryButtonAction,
        secondaryText = dialogTexts.secondaryButtonText?.localized,
        secondaryAction = secondaryButtonAction
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomDialog(
    title: String,
    description: String,
    primaryText: String,
    primaryAction: () -> Unit,
    secondaryText: String? = null,
    secondaryAction: (() -> Unit)? = null
) {

    Dialog(
        onDismissRequest = { primaryAction() },
        properties = DialogProperties(
            dismissOnClickOutside = false,
            usePlatformDefaultWidth = false
        )
    ) {
        Surface(
            shape = RoundedCornerShape(Resources.Dimen.surface.roundedCorner),
            color = Resources.Theme.surface.getColor(),
            modifier = Modifier.fillMaxWidth(0.88f)
        ) {
            Column(
                modifier = Modifier.padding(
                start = Resources.Spacing.big.dp,
                top = Resources.Spacing.medium.dp + Resources.Spacing.extraTiny.dp,
                end = Resources.Spacing.big.dp,
                bottom = Resources.Spacing.big.dp
                )
            ) {

                Text(
                    text = title,
                    style = TextStyles.h2,
                    color = Resources.Theme.textPrimary.getColor(),
                    maxLines = 2
                )

                Spacing.Small()

                Text(
                    text = description,
                    style = TextStyles.textField,
                    color = Resources.Theme.textPrimary.getColor(),
                    maxLines = Int.MAX_VALUE
                )

                Spacing.Big()

                PrimaryButton(
                    text = primaryText,
                    onClick = { primaryAction()},
                    modifier = Modifier.fillMaxWidth()
                )

                if (secondaryText != null && secondaryAction != null) {
                    Spacing.Normal()

                    PrimaryGrayButton(
                        text = secondaryText,
                        onClick = { secondaryAction() },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun SingleActionDialogPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        CustomDialog(
            title = "Atualizar App",
            description = "Para continar usando o app, você precisa atualiza-lo.",
            primaryText = "Atualizar",
            primaryAction = { }
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun DoubleActionDialogPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        CustomDialog(
            title = "Cadastro",
            description = "Voce tem certeza que deseja cancelar o cadastro?",
            primaryText = "Cancelar",
            primaryAction = { },
            secondaryText = "Continuar",
            secondaryAction = { }
        )
    }
}