package br.com.progdeelite.kmmprogdeelite.localization

import br.com.progdeelite.kmmprogdeelite.resources.Resources
import br.com.progdeelite.kmmprogdeelite.resources.TextResource

data class LanguagePickerTexts (
    val title: TextResource,
    val languageOptions: List<Language>
) {
    constructor() : this(
        title = Resources.Strings.app_language,
        languageOptions = Language.getLanguages()
    )
}