package br.com.progdeelite.kmmprogdeelite.localization

import br.com.progdeelite.kmmprogdeelite.di.DI.inject

/** In case the localization service license expires, we take the default value from available R.strings */
expect fun getDefaultString(name: String): String

interface LocalizationService {

    // acesso fácil e comum tanto para iOS como para Android
    companion object {
        val instance by inject<LocalizationService>()
    }

    fun lokalise(stringRef: String): String
    fun loadResources()
    fun changeLanguage(language: Language)
    fun getCurrentLanguage(): Language
}

class Localization: LocalizationService {

    private val lokalisable by inject<Lokalisable>()

    override fun lokalise(stringRef: String): String {
        return lokalisable.lokalise(stringRef) ?: getDefaultString(stringRef)
    }

    override fun loadResources() = lokalisable.loadResources()

    override fun changeLanguage(language: Language) {
        lokalisable.changeLanguage(language)
        // TODO: save in settings later as soon as settings service is available
        loadResources()
    }

    override fun getCurrentLanguage(): Language {
        // TODO: get from settings service later to ensure language migration
        return lokalisable.geLokaliseLanguage()
    }
}