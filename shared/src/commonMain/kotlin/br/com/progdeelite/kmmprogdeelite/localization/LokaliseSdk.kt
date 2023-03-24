package br.com.progdeelite.kmmprogdeelite.localization

/** common interface for lokalise.com */
interface LokaliseSdk {
    /**
     * @param stringRef string reference stored in the cloud from lokalise.com
     */
    fun lokalise(stringRef: String): String?

    /**
     * Call this method whenever the changeLanguage method is called.
     */
    fun loadResources()

    /**
     * Call this method whenever you whant to switch languages
     */
    fun changeLanguage(language: Language)


    fun geLokaliseLanguage(): Language
}