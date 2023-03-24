package br.com.progdeelite.kmmprogdeelite.localization

import br.com.progdeelite.kmmprogdeelite.di.DI

/** In case the localization service license expires, we take the default value from available R.strings */
expect fun getDefaultString(name: String): String

interface LocalizationService {

    // acesso fácil e comum tanto para iOS como para Android
    companion object {
        private val instance by DI.injectInternal<LocalizationService>()
    }

    fun lokalise(stringRef: String): String
    fun loadResources()
    fun changeLanguage(language: Language)
    fun getCurrentLanguage(): Language
}

internal class Localization: LocalizationService {

    private val lokaliseSdk by DI.inject<LokaliseSdk>()

    override fun lokalise(stringRef: String): String {
        return lokaliseSdk.lokalise(stringRef) ?: getDefaultString(stringRef)
    }

    override fun loadResources() = lokaliseSdk.loadResources()

    override fun changeLanguage(language: Language) {
        lokaliseSdk.changeLanguage(language)
        // TODO: save in settings later as soon as settings service is available
        loadResources()
    }

    override fun getCurrentLanguage(): Language {
        // TODO: get from settings service later to ensure language migration
        return lokaliseSdk.geLokaliseLanguage()
    }
}