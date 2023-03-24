package br.com.progdeelite.kmmprogdeelite.resources

import br.com.progdeelite.kmmprogdeelite.di.DI.inject
import br.com.progdeelite.kmmprogdeelite.di.DI.injectInternal
import br.com.progdeelite.kmmprogdeelite.localization.LocalizationService

// 1) Definir dependencias
// 2) especificar interface de localização e implementar nas plataformas
// 3) injetar dependências através de DI
// 4) Definir interface do servico de localizazão e usar localização
// 5) especificar dependências através de DI
// 6) Criar classe TextResource para compartilhar textos
// 7) Definir strings em Resources, StringsResources e strings.xml (fallback)
// 8) Criar os textos de onboarding em OnBoardingTexts
// 9) Mostrar uso na prática no OnboardingViewModel (OnBoardingTexts)
// 10) Ver uso na prática dentro da OnboardingScreen

/**
 * Android and iOS localizes its text references over the Lokalise-SDK.
 * @param name resource name declared in the lokalise cloud
 */
class TextResource(val name: String) {

    private var _text: String = ""
    private val service by injectInternal<LocalizationService>()

    private fun localized(): String {
        return _text.ifBlank { service.lokalise(name) }
    }

    val localized: String
        get() = this.localized()

    internal fun setText(text: String) {
        _text = text
    }
}

fun getTextResource(text: String): TextResource {
    val resource = TextResource("")
    resource.setText(text)
    return resource
}

abstract class TextFieldErrorType(val text: TextResource) {

    object None : TextFieldErrorType(
        text = TextResource("")
    )

    object NumberNotFound : TextFieldErrorType(
        text = Resources.Strings.textfield_number_not_found
    )

    object InvalidBirthdate : TextFieldErrorType(
        text = Resources.Strings.textfield_invalid_birthdate
    )

    object InvalidCode : TextFieldErrorType(
        text = Resources.Strings.textfield_invalid_code
    )
}