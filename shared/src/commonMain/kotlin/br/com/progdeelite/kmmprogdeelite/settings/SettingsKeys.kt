package br.com.progdeelite.kmmprogdeelite.settings

// 1) Adicionar dependencias
// 2) Criar/Pensar nas keys de migração e novas
// 3) Criar Settings em ambas as plataformas
// 4) Criar Serviço de settings para os apps
// 5) Adicionar no mecanismo de dependency injection

object SettingsKeys {
    // ************************* PAY ATTENTION *****************************
    // DO NOT CHANGE THIS PROP NAME. IT MUST BE COMPATIBLE WITH OLD VERSION
    // *********************************************************************
    const val PREF_KEY_LANGUAGE = "pref_key_app_language"
    const val PREF_KEY_LANGUAGE_REGION = "pref_key_app_region"
}