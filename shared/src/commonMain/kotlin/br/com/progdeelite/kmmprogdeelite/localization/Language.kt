package br.com.progdeelite.kmmprogdeelite.localization

enum class Language(val isoCode: String, val region: String, val text: String) {
    DE_CH("de", "CH", "Deutsch - Schweiz"),
    DE_AT("de", "AT", "Deutsch - Österreich"),
    IT_CH("it", "CH", "Italiano"),
    FR_CH("fr", "CH", "Français");

    companion object {

        val fallback: Language = DE_CH

        fun getLanguageByIsoCodeAndRegion(isoCode: String, region: String): Language {
            return values().find { language ->
                language.isoCode.equals(isoCode, true) &&
                        language.region.equals(region, true)
            } ?: getDefaultLanguage()
        }

        /** @param isoCode low case country iso code. ex: "de", "it" etc. */
        fun getDefaultLanguageByIsoCode(isoCode: String): Language {
            return when(isoCode){
                DE_CH.isoCode -> DE_CH
                IT_CH.isoCode -> IT_CH
                FR_CH.isoCode -> FR_CH
                else -> fallback
            }
        }

        fun getLanguages(): List<Language> = values().toList()

        fun getDefaultLanguage(): Language = DE_CH
    }
}