package br.com.progdeelite.kmmprogdeelite.di

import br.com.progdeelite.kmmprogdeelite.localization.Language
import br.com.progdeelite.kmmprogdeelite.localization.LokaliseSdk
import br.com.progdeelite.kmmprogdeelite.network.Environment
import br.com.progdeelite.kmmprogdeelite.tracking.adobe.AdobeAnalyticsSdk

internal fun fakeDI(){
    DI.Native.environment = Environment.DEV
    DI.Native.lokaliseSdk = FakeLokalise()
    DI.Native.adobeAnalyticsSdk = FakeAdobeAnalytics()
}

class FakeLokalise: LokaliseSdk {
    override fun lokalise(stringRef: String): String = stringRef
    override fun loadResources() {}
    override fun changeLanguage(language: Language) {}
    override fun geLokaliseLanguage(): Language = Language.getDefaultLanguage()
}

class FakeAdobeAnalytics: AdobeAnalyticsSdk {
    override fun trackAction(name: String, contextData: Map<String, String>) {}
    override fun trackScreen(name: String, contextData: Map<String, String>?) {}
    override fun setProperty(name: String, value: String) {}
    override fun unsetProperty(name: String) {}
}