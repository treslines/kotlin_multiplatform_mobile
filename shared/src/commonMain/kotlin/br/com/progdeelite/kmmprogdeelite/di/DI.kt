package br.com.progdeelite.kmmprogdeelite.di

import br.com.progdeelite.kmmprogdeelite.di.DI.Native.adobeAnalyticsSdk
import br.com.progdeelite.kmmprogdeelite.di.DI.Native.environment
import br.com.progdeelite.kmmprogdeelite.di.DI.Native.lokaliseSdk
import br.com.progdeelite.kmmprogdeelite.localization.Localization
import br.com.progdeelite.kmmprogdeelite.localization.LocalizationService
import br.com.progdeelite.kmmprogdeelite.localization.LokaliseSdk
import br.com.progdeelite.kmmprogdeelite.network.Environment
import br.com.progdeelite.kmmprogdeelite.settings.AppSettings
import br.com.progdeelite.kmmprogdeelite.settings.SettingsService
import br.com.progdeelite.kmmprogdeelite.tracking.adobe.AdobeAnalyticsSdk
import br.com.progdeelite.kmmprogdeelite.tracking.adobe.AnalyticsService
import br.com.progdeelite.kmmprogdeelite.tracking.adobe.AnalyticsTracker
import kotlin.native.concurrent.ThreadLocal

// 1) Renomear AndroidApp para AndroidMainApp e criar IOSMainApp
// 2) Mover dependencias comuns para DI
// 3) Criar DependencyInjectionForPreview para android
// 4) Defnir Fakes para Android
// 5) Mostrar no OnboardingViewModel e OnboardingScreen


/**
 * CUSTOM DEPENDENCY INJECTION - HOW TO USE IT:
 *
 * 1) Add dependency either to Native (direct in lookup from method inject)
 * 2) If Native, initialize it by assigning its value over MainApplication(Android)/UIApplicationDelegate(iOS)
 * 3) Add new lookup to inject method
 *
 * Usage (example):
 * val environments by inject<Environment>() OR val environment: Environment by inject()
 */
object DI {

    @ThreadLocal
    object Native {
        // 1)
        lateinit var environment: Environment // 2) will be initialized in MainApplication/UIApplicationDelegate
        lateinit var lokaliseSdk: LokaliseSdk
        lateinit var adobeAnalyticsSdk: AdobeAnalyticsSdk
    }

    inline fun <reified T> inject(): Lazy<T> {
        // 3)
        return when (T::class) {
            Environment::class -> lazy { environment as T }
            LokaliseSdk::class -> lazy { lokaliseSdk as T }
            AdobeAnalyticsSdk::class -> lazy { adobeAnalyticsSdk as T }
            SettingsService::class -> lazy { AppSettings() as T }
            else -> throw IllegalArgumentException("Dependency not found! Specify class \"${T::class.qualifiedName}\" in DI.inject()")
        }
    }

    internal inline fun <reified T> injectInternal(): Lazy<T> {
        return when (T::class) {
            AnalyticsService::class -> lazy { AnalyticsTracker() as T }
            LocalizationService::class -> lazy { Localization() as T }
            else -> throw IllegalArgumentException("Dependency not found! Specify class \"${T::class.qualifiedName}\" in DI.injectInternal()")
        }
    }

    // for android preview [see DependencyInjectionForPreview] and testing later on
    fun fake() = fakeDI()
}