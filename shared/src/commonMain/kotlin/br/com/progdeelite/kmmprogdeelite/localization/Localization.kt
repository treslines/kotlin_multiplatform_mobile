package br.com.progdeelite.kmmprogdeelite.localization

import br.com.progdeelite.kmmprogdeelite.di.DI
import br.com.progdeelite.kmmprogdeelite.settings.SettingsService

/** In case the localization service license expires,
 * we take the default value from available R.strings */
expect fun getDefaultString(name: String): String

// 1) DIAGRAMA SERVICOS
// 2) DEFINIR INTERFACE DE SERVICO
// 3) IMPLEMENTAR SERVICO INTERNO
// 4) ADICIONAR SERVICO A INJECÃO DE DEPENDENCIA
interface LocalizationService {

    // acesso fácil e comum tanto para iOS como para Android
    companion object {
        val instance by DI.injectInternal<LocalizationService>()
    }

    fun lokalise(stringRef: String): String
    fun loadResources()
    fun setLanguage(language: Language)
    fun getCurrentLanguage(): Language
}

internal class Localization: LocalizationService {

    private val lokaliseSdk by DI.inject<LokaliseSdk>() // assista o video de localizacão
    private val settings by DI.injectInternal<SettingsService>() // assista o video de settings

    override fun lokalise(stringRef: String): String {
        return lokaliseSdk.lokalise(stringRef) ?: getDefaultString(stringRef) // Lokalise license expired
    }

    override fun loadResources() = lokaliseSdk.loadResources()

    override fun setLanguage(language: Language) {
        lokaliseSdk.changeLanguage(language)
        settings.setLanguage(language)
        loadResources()
    }

    override fun getCurrentLanguage(): Language {
        // Read language from settings, if null return lokalise language or fallback
        return settings.getLanguage() ?: return lokaliseSdk.geLokaliseLanguage()
    }
}