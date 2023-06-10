package br.com.progdeelite.kmmprogdeelite.validations

import br.com.progdeelite.kmmprogdeelite.resources.Resources
import br.com.progdeelite.kmmprogdeelite.resources.TextResource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

// 1) Como criar tipos para validar campos de texto
// 2) Como criar os erros que serão observados
// 3) Como criar as regras de validação
// 4) Como criar o validador para usar e observar os estados de erro nos componentes

class TextFieldValidator(
    val type: TextFieldType = TextFieldType.Default
) {
    private val _error = MutableStateFlow<TextFieldErrorType>(TextFieldErrorType.None)
    val error: StateFlow<TextFieldErrorType> = _error

    fun updateErrorState(input: String) {
        setErrorState(validate(input))
    }

    fun setErrorState(errorType: TextFieldErrorType) {
        _error.tryEmit(errorType)
    }

    private fun validate(input: String): TextFieldErrorType {
        return when (type) {
            TextFieldType.PhoneNumber -> TextFieldValidations.phoneNumber(input)
            TextFieldType.Otp -> TextFieldValidations.otpCode(input)
            else -> TextFieldErrorType.None
        }
    }

    fun isValid(input: String): Boolean {
        return validate(input) == TextFieldErrorType.None
    }
}

// 3)
object TextFieldValidations {
    fun empty(input: String) = if (input.isEmpty()) TextFieldErrorType.EmptyField else TextFieldErrorType.None
    fun phoneNumber(input: String) = if (input.length in 3..18) TextFieldErrorType.None else TextFieldErrorType.PhoneNumberInvalidFormat
    fun birthday(input: String) = if (input.length != 10) TextFieldErrorType.InvalidBirthdate else TextFieldErrorType.None
    fun otpCode(input: String) = if (input.length != 6) TextFieldErrorType.InvalidCode else TextFieldErrorType.None

    fun onValidInputs(errorTypes: List<TextFieldErrorType>, success: () -> Unit = {}, failure: () -> Unit = {}) {
        if (errorTypes.all { it == TextFieldErrorType.None }) success() else failure()
    }
}

// 2)
abstract class TextFieldErrorType(val text: TextResource) {

    object None : TextFieldErrorType(
        text = TextResource("")
    )

    object EmptyField : TextFieldErrorType(
        text = Resources.Strings.textfield_empty
    )

    object PhoneNumberNotFound : TextFieldErrorType(
        text = Resources.Strings.textfield_number_not_found
    )

    object PhoneNumberInvalidFormat : TextFieldErrorType(
        text = Resources.Strings.textfield_invalid_phone_number_format
    )

    object InvalidBirthdate : TextFieldErrorType(
        text = Resources.Strings.textfield_invalid_birthdate
    )

    object InvalidCode : TextFieldErrorType(
        text = Resources.Strings.textfield_invalid_code
    )

    object CodeExpired : TextFieldErrorType(
        text = Resources.Strings.textfield_code_expired
    )
}

// 1)
enum class TextFieldType {
    Default, PhoneNumber, Otp
}