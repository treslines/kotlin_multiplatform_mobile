package br.com.progdeelite.kmmprogdeelite.android.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.progdeelite.kmmprogdeelite.android.R
import br.com.progdeelite.kmmprogdeelite.android.modifiers.onFocusChangedIgnoreInitialState
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.AndroidAppTheme
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.TextStyles
import br.com.progdeelite.kmmprogdeelite.android.utils.DependencyInjectionForPreview
import br.com.progdeelite.kmmprogdeelite.resources.ImageResource
import br.com.progdeelite.kmmprogdeelite.resources.Resources
import br.com.progdeelite.kmmprogdeelite.resources.components.ResendSmsResources
import br.com.progdeelite.kmmprogdeelite.resources.getPreviewImageResource
import br.com.progdeelite.kmmprogdeelite.resources.getTextResource
import br.com.progdeelite.kmmprogdeelite.tracking.adobe.AnalyticsAction
import br.com.progdeelite.kmmprogdeelite.tracking.adobe.AnalyticsService
import br.com.progdeelite.kmmprogdeelite.validations.TextFieldErrorType
import br.com.progdeelite.kmmprogdeelite.validations.TextFieldType
import br.com.progdeelite.kmmprogdeelite.validations.TextFieldValidator
import kotlinx.coroutines.delay

// 1) COMO CRIAR CAMPO SMS QUE VALIDA SMS
// 2) COMO USAR VALIDATOR E COUNT DOWN DE SMS
// 3) COMO OBSERVAR OS ESTADOS PARA ATIVAR OU DESATIVAR BOTÃO DE FORMULÁRIO
// 4) USAR NA PRÁTICA DENTRO DA MAIN ACTIVITY (EXEMPLO PRÁTICO)

@Composable
fun ResendSmsTextField(
    initialInput: String = "",
    resendSeconds: Int = 10,
    allowedRetries: Int = 5,
    autofocus: Boolean = false,
    validator: TextFieldValidator = TextFieldValidator(TextFieldType.Otp),
    onResendSmsClick: () -> Unit = {},
    onSmsInputChange: (input: String) -> Unit = {},
    resources: ResendSmsResources = ResendSmsResources(),
) {
    // VOCE PODERIA TBM (SE FOR ALGO RESUSÁVEL) ESTRAIR PARA UM UI STATE
    val errorState by validator.error.collectAsState()
    var resend by remember { mutableStateOf(false) }
    var seconds by remember { mutableStateOf("$resendSeconds") }
    var retries by remember { mutableStateOf(allowedRetries) }

    if (retries == 0) {
        AnalyticsService.instance.trackAction(AnalyticsAction.TooManySmsAction)
    }
    if (resend) {
        LaunchedEffect(true) {
            for (countDown in resendSeconds - 1 downTo 0) {
                delay(1000)
                seconds = "$countDown"
                if (countDown == 0) {
                    resend = false
                    seconds = "$resendSeconds"
                }
            }
            retries--
        }
    }
    Row {
        AccessibilityText(
            modifier = Modifier,
            text = resources.title.localized,
            maxLines = 1,
            style = TextStyles.textFieldSms,
            color = Resources.Theme.textPrimary.getColor()
        )
        Spacer(modifier = Modifier.weight(1f, true))
        if (retries > 0) {
            SmsResendText(
                disable = resend,
                sendText = resources.sendSmsText.localized,
                resendText = resources.resendSmsText.localized,
                secondsText = seconds,
                style = TextStyles.textFieldSms,
                onClick = {
                    resend = true
                    onResendSmsClick()
                    AnalyticsService.instance.trackAction(AnalyticsAction.TooManySmsAction)
                }
            )
        }
    }
    Spacing.Tiny()
    CustomTextField(
        initialInput = initialInput,
        autofocus = autofocus,
        textFieldHint = resources.placeholder.localized,
        errorTypeState = errorState,
        imeAction = ImeAction.Next,
        keyboardType = KeyboardType.Number,
        validator = validator,
        onInputChange = onSmsInputChange,
        trailingIcon = { TrailingIcon(resources.errorIcon) }
    )
}

@Composable
fun TrailingIcon(imageResource: ImageResource) = Icon(
    modifier = Modifier.size(Resources.Dimen.icon.tiny),
    contentDescription = null,
    painter = painterResource(id = imageResource.id),
    tint = Resources.Theme.error.getColor()
)


// 1) COMO CRIAR ESTADOS COMPARTILHADOS PARA VALIDAçÃO DE CAMPOS DE TEXTO
// 2) COMO DEFINIR OS ESTILOS DOS CAMPOS DE TEXTO E FONT SIZE COMPARTILHADO
// 3) COMO UTILIZAR RECURSOS DE CORES, DIMENSÕES COMPARTILHADOS
// 4) COMO CRIAR UM CAMPO DE TEXTO CUST0MIZADO - REUTILIZÁVEL

@Composable
fun DefaultTextInputField(
    initialInput: String = "",
    textFieldHint: String = "",
    autofocus: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    errorTypeState: TextFieldErrorType = TextFieldErrorType.None,
    onInputChange: (input: String) -> Unit = {}
) {
    CustomTextField(
        initialInput = initialInput,
        autofocus = autofocus,
        keyboardType = keyboardType,
        imeAction= imeAction,
        trailingIcon = { Icon(imageVector = Icons.Default.Error, contentDescription = null) },
        textFieldHint = textFieldHint,
        errorTypeState = errorTypeState,
        onInputChange = onInputChange
    )
}

// 1) COMO OBTER O FOCUS EM CAMPOS DE TEXTO
// 2) COMO MANIPULAR O TECLADO VIRTUAL
// 3) COMO FECHAR O TECLADO AO PRESSIONAR ENTER
// 4) COMO ALTERAR O TIPO DO TECLADO
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomTextField(
    initialInput: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    autofocus: Boolean = false,
    trailingIcon: @Composable (() -> Unit)? = null,
    textFieldHint: String = "",
    errorTypeState: TextFieldErrorType,
    validator: TextFieldValidator = TextFieldValidator(TextFieldType.Default),
    onInputChange: (input: String) -> Unit = {}
) {

    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current

    var input by remember { mutableStateOf(TextFieldValue(initialInput)) }

    return Column {

        if (autofocus) {
            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }
        }

        val modifier = Modifier
            .fillMaxWidth()
            .height(Resources.Dimen.textInputField.minHeight)
            .onFocusChangedIgnoreInitialState {
                if (it.isFocused) return@onFocusChangedIgnoreInitialState
                validator.updateErrorState(input.text)
            }

        OutlinedTextField(
            value = input,
            singleLine = true,
            isError = errorTypeState != TextFieldErrorType.None,
            modifier = when (autofocus) {
                true -> modifier.focusRequester(focusRequester)
                else -> modifier
            },
            shape = RoundedCornerShape(Resources.Dimen.textInputField.roundCorner),
            trailingIcon = if (errorTypeState != TextFieldErrorType.None) trailingIcon else null,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
            keyboardActions = KeyboardActions {
                keyboardController?.hide()
                focusManager.clearFocus()
                onInputChange(input.text)
            },
            onValueChange = {
                input = it
                onInputChange(it.text)
            },

            textStyle = TextStyles.textField,

            placeholder = {
                Text(
                    text = textFieldHint,
                    color = Resources.Theme.textFieldHintColor.getColor()
                )
            },

            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Resources.Theme.backgroundSecondary.getColor(),
                cursorColor = Resources.Theme.textFieldCursorColor.getColor(),
                textColor = if (errorTypeState == TextFieldErrorType.None) MaterialTheme.colors.error else LocalContentColor.current.copy(LocalContentAlpha.current),
                focusedIndicatorColor = Resources.Theme.textFieldSelectedFocusColor.getColor(),
                unfocusedIndicatorColor = Resources.Theme.textFieldUnselectedFocusColor.getColor(),
            ),
        )

        Spacing.Tiny()

        when (errorTypeState) {
            TextFieldErrorType.PhoneNumberNotFound -> ErrorHintText(errorTypeState)
            TextFieldErrorType.InvalidBirthdate -> ErrorHintText(errorTypeState)
            TextFieldErrorType.InvalidCode -> ErrorHintText(errorTypeState)
            else -> ErrorHintText(TextFieldErrorType.None)
        }
    }
}

@Composable
private fun ErrorHintText(errorType: TextFieldErrorType) {
    Text(
        text = errorType.text.localized,
        style = TextStyles.textFieldHint,
        color = MaterialTheme.colors.error
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showSystemUi = true, showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true, showBackground = true)
@Composable
fun InputFieldsPreview() {
    DependencyInjectionForPreview()

    AndroidAppTheme {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            ResendSmsTextField(
                resources = ResendSmsResources(
                    title = getTextResource("Código SMS"),
                    sendSmsText = getTextResource("Solicitar SMS"),
                    resendSmsText = getTextResource("Próximo SMS em {0}"),
                    placeholder = getTextResource("Insira Código SMS"),
                    errorIcon = getPreviewImageResource(R.drawable.info)
                )
            )

            Spacing.Big()
            DefaultTextInputField(
                initialInput = "076 888 44 222",
                keyboardType = KeyboardType.Phone,
                errorTypeState = TextFieldErrorType.PhoneNumberNotFound
            )

            Spacing.Big()

            DefaultTextInputField(
                textFieldHint = "066 888 44 22",
                keyboardType = KeyboardType.Phone,
                errorTypeState = TextFieldErrorType.None
            )

            Spacing.ExtraHuge()

            DefaultTextInputField(
                initialInput = "11/12-2023",
                keyboardType = KeyboardType.Text,
                errorTypeState = TextFieldErrorType.InvalidBirthdate
            )

            Spacing.Big()

            DefaultTextInputField(
                textFieldHint = "11/12/2023",
                keyboardType = KeyboardType.Text,
                errorTypeState = TextFieldErrorType.None
            )

            Spacing.ExtraHuge()

            DefaultTextInputField(
                initialInput = "815444",
                keyboardType = KeyboardType.Number,
                errorTypeState = TextFieldErrorType.InvalidCode
            )

            Spacing.Big()

            DefaultTextInputField(
                textFieldHint = "815444",
                keyboardType = KeyboardType.Number,
                errorTypeState = TextFieldErrorType.None
            )
        }
    }
}