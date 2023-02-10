package br.com.progdeelite.kmmprogdeelite.di

import br.com.progdeelite.kmmprogdeelite.localization.Language
import br.com.progdeelite.kmmprogdeelite.localization.Lokalisable
import br.com.progdeelite.kmmprogdeelite.network.Environment

internal fun fakeDI(){
    DI.Native.environment = Environment.DEV
    DI.Native.lokalisable = FakeLokalise()
}

class FakeLokalise: Lokalisable {
    override fun lokalise(stringRef: String): String = stringRef
    override fun loadResources() {}
    override fun changeLanguage(language: Language) {}
    override fun geLokaliseLanguage(): Language = Language.getDefaultLanguage()
}