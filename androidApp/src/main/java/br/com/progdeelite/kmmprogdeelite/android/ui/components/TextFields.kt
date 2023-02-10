package br.com.progdeelite.kmmprogdeelite.android.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.AndroidAppTheme
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.TextStyles
import br.com.progdeelite.kmmprogdeelite.android.utils.DependencyInjectionForPreview
import br.com.progdeelite.kmmprogdeelite.resources.Resources
import br.com.progdeelite.kmmprogdeelite.resources.TextFieldErrorType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

// 1) COMO CRIAR ESTADOS COMPARTILHADOS PARA VALIDAçÃO DE CAMPOS DE TEXTO
// 2) COMO DEFINIR OS ESTILOS DOS CAMPOS DE TEXTO E FONT SIZE COMPARTILHADO
// 3) COMO UTILIZAR RECURSOS DE CORES, DIMENSÕES COMPARTILHADOS
// 4) COMO CRIAR UM CAMPO DE TEXTO CUST0MIZADO - REUTILIZÁVEL

@Composable
fun DefaultTextInputField(
    initialInput: String = "",
    textFieldHint: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    errorState: StateFlow<Boolean> = MutableStateFlow(false),
    errorTypeState: StateFlow<TextFieldErrorType> = MutableStateFlow(TextFieldErrorType.None),
    onInputChange: (input: String) -> Unit = {}
) {
    CustomTextField(
        initialInput = initialInput,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        trailingIcon = { Icon(imageVector = Icons.Default.Error, contentDescription = null) },
        textFieldHint = textFieldHint,
        errorState = errorState,
        errorTypeState = errorTypeState,
        onInputChange = onInputChange
    )
}

@Composable

fun CustomTextField(
    initialInput: String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    trailingIcon: @Composable (() -> Unit)? = null,
    textFieldHint: String = "",
    errorState: StateFlow<Boolean>,
    errorTypeState: StateFlow<TextFieldErrorType>,
    onInputChange: (input: String) -> Unit = {}
) {

    val error by errorState.collectAsState()
    val errorType by errorTypeState.collectAsState()
    var input by remember { mutableStateOf(TextFieldValue(initialInput)) }

    return Column {

        OutlinedTextField(
            value = input,
            singleLine = true,
            isError = error,
            modifier = Modifier.height(Resources.Dimen.textInputField.minHeight),
            shape = RoundedCornerShape(Resources.Dimen.textInputField.roundCorner),
            trailingIcon = if (error) trailingIcon else null,
            keyboardOptions = keyboardOptions,
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
                    textColor = if (error) MaterialTheme.colors.error else LocalContentColor.current.copy(LocalContentAlpha.current),
                    focusedIndicatorColor = Resources.Theme.textFieldSelectedFocusColor.getColor(),
                    unfocusedIndicatorColor = Resources.Theme.textFieldUnselectedFocusColor.getColor(),
                ),
            )

        Spacing.Tiny()

        when (errorType) {
            TextFieldErrorType.NumberNotFound -> ErrorHintText(errorType)
            TextFieldErrorType.InvalidBirthdate -> ErrorHintText(errorType)
            TextFieldErrorType.InvalidCode -> ErrorHintText(errorType)
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

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun InputFieldsPreview() {
    DependencyInjectionForPreview()

    val errorStateTrue: StateFlow<Boolean> = MutableStateFlow(true)
    val errorStateFalse: StateFlow<Boolean> = MutableStateFlow(false)
    val errorNumberNotFound: StateFlow<TextFieldErrorType> = MutableStateFlow(TextFieldErrorType.NumberNotFound)
    val errorInvalidDate: StateFlow<TextFieldErrorType> = MutableStateFlow(TextFieldErrorType.InvalidBirthdate)
    val errorInvalidCode: StateFlow<TextFieldErrorType> = MutableStateFlow(TextFieldErrorType.InvalidCode)
    val errorNone: StateFlow<TextFieldErrorType> = MutableStateFlow(TextFieldErrorType.None)

    AndroidAppTheme {
        Column {
            DefaultTextInputField(
                initialInput = "076 888 44 22",
                keyboardType = KeyboardType.Phone,
                errorState = errorStateTrue,
                errorTypeState = errorNumberNotFound
            )

            Spacing.Big()

            DefaultTextInputField(
                textFieldHint = "066 888 44 22",
                keyboardType = KeyboardType.Phone,
                errorState = errorStateFalse,
                errorTypeState = errorNone
            )

            Spacing.ExtraHuge()

            DefaultTextInputField(
                initialInput = "11/12-2023",
                keyboardType = KeyboardType.Text,
                errorState = errorStateTrue,
                errorTypeState = errorInvalidDate
            )

            Spacing.Big()

            DefaultTextInputField(
                textFieldHint = "11/12/2023",
                keyboardType = KeyboardType.Text,
                errorState = errorStateFalse,
                errorTypeState = errorNone
            )

            Spacing.ExtraHuge()

            DefaultTextInputField(
                initialInput = "815444",
                keyboardType = KeyboardType.Number,
                errorState = errorStateTrue,
                errorTypeState = errorInvalidCode
            )

            Spacing.Big()

            DefaultTextInputField(
                textFieldHint = "815444",
                keyboardType = KeyboardType.Number,
                errorState = errorStateFalse,
                errorTypeState = errorNone
            )
        }
    }
}