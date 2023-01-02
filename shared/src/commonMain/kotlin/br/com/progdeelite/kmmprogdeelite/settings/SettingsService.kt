package br.com.progdeelite.kmmprogdeelite.settings

import br.com.progdeelite.kmmprogdeelite.di.DI
import br.com.progdeelite.kmmprogdeelite.localization.Language

interface SettingsService {

    // acesso fácil e comum tanto para iOS como para Android
    companion object {
        val instance by DI.inject<SettingsService>()
    }

    fun storeAppLanguage(langague: Language)
    fun restoreAppLanguage(language: Language): Language
    // ... outras preferencias e settings que seu app tenha
}

class AppSettings: SettingsService {

    private val settings = getSettings()

    override fun storeAppLanguage(langague: Language) {
        settings?.let {
            it.putString(SettingsKeys.PREF_KEY_LANGUAGE, langague.isoCode)
            it.putString(SettingsKeys.PREF_KEY_LANGUAGE_REGION, langague.region)
        }
    }

    override fun restoreAppLanguage(language: Language): Language {
        val defaultLang = Language.getDefaultLanguage()
        settings?.let {
            val appIsoCode = it.getString(SettingsKeys.PREF_KEY_LANGUAGE, defaultLang.isoCode)
            val appRegion = it.getString(SettingsKeys.PREF_KEY_LANGUAGE_REGION, defaultLang.region)
            return Language.getLanguageByIsoCodeAndRegion(appIsoCode, appRegion)
        }
        return defaultLang
    }
}