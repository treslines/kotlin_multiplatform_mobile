package br.com.progdeelite.kmmprogdeelite.tracking.adobe

import br.com.progdeelite.kmmprogdeelite.di.DI

// 1) DEFINIR DEPENDENCIAS
// 2) DEFINIR ACÕES, INFOS DE TELAS, PROPERTIES
// 3) DEFINIR INTERFACE, IMPLEMENTAR EM ANDROID
// 4) INJETAR A DEPENDENCIA EM DI ATRAVES DA MAIN APPLICATION
// 5) IMPLEMENTAR SERVICO COMUM PARA IOS e ANDROID

enum class AnalyticsAction(val actionName: String, val actionContext: String?) {

    DiscoverAction("discover", "Explorar App"),
    LanguageAction("language_switch", null),
    LoginAction("login", "Entrar no App"),
    SupportEmailAction("support_email", "Suporte via E-Mail"),
    SupportCallAction("support_call", "Supporte via telefone"),
    NavHomeAction("nav_home", "Navegou para Tela Inicial"),
    NavInsuranceAction("nav_insurance", "Navegou para Tela de Seguros"),
    NavSupportAction("nav_help", "Navegou para Tela de Suporte"),
    NavProfileAction("nav_profile", "Navegou para Tela de Perfil");

    companion object {
        fun getContext(action: AnalyticsAction) = if (action.actionContext == null) mapOf() else mapOf("context" to action.actionContext)
    }
}

enum class ScreenInfo(val screenName: String) {
    HomeScreen("home"),
    InsuranceScreen("insurance"),
    SupportScreen("help"),
    ProfileScreen("profile"),
    AnimationScreen("intro"),
    OnboardingScreen("onboarding")
}

enum class AnalyticsProperty(val propertyName: String) {
    AppLanguage("AppLanguage")
}

interface AdobeAnalyticsSdk {
    fun trackAction(name: String, contextData: Map<String, String>)
    fun trackScreen(name: String, contextData: Map<String, String>? = null)
    fun setProperty(name: String, value: String)
    fun unsetProperty(name: String)
}

interface AnalyticsService {

    companion object {
        private val instance by DI.injectInternal<AnalyticsService>()
    }

    fun trackScreen(screen: ScreenInfo, contextData: Map<String, String>? = null)
    fun trackAction(action: AnalyticsAction, contextData: Map<String, String>? = null)
    fun setProperty(property: AnalyticsProperty, value: String)
    fun unsetProperty(property: AnalyticsProperty)
}


internal class AnalyticsTracker : AnalyticsService {

    private val adobeAnalytics by DI.inject<AdobeAnalyticsSdk>()

    override fun trackAction(action: AnalyticsAction, contextData: Map<String, String>?) {
        val combined = AnalyticsAction.getContext(action).toMutableMap()
        if (contextData != null) {
            combined.putAll(contextData)
        }
        adobeAnalytics.trackAction(action.actionName, combined)
    }

    override fun trackScreen(screen: ScreenInfo, contextData: Map<String, String>?) {
        adobeAnalytics.trackScreen(screen.screenName, contextData)
    }

    override fun setProperty(property: AnalyticsProperty, value: String) {
        adobeAnalytics.setProperty(property.propertyName, value)
    }

    override fun unsetProperty(property: AnalyticsProperty) {
        adobeAnalytics.unsetProperty(property.propertyName)
    }
}
