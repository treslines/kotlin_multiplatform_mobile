package br.com.progdeelite.kmmprogdeelite.android.localization

import android.content.Context
import br.com.progdeelite.kmmprogdeelite.android.BuildConfig
import br.com.progdeelite.kmmprogdeelite.localization.Language
import br.com.progdeelite.kmmprogdeelite.localization.LokaliseSdk
import br.com.progdeelite.kmmprogdeelite.utils.logD
import com.lokalise.sdk.Lokalise
import com.lokalise.sdk.LokaliseCallback
import com.lokalise.sdk.LokaliseResources
import com.lokalise.sdk.LokaliseUpdateError
import java.util.Locale

class LocaliseSdkWrapper (private val appContext: Context): LokaliseSdk {

    private val logContext = "LocaliseSdkWrapper"
    init {
        // TODO: comentado pois não esta sendo usado no projeto, apenas para fins didáticos
        Lokalise.init(appContext, "CommonConfig.LOKALISE_TOKEN", "CommonConfig.LOKALISE_PROJEKT_ID")
        if (BuildConfig.DEBUG) {
            Lokalise.isPreRelease = true // Configuration in Lokalise dashboard to take all strings while developing
        }

        // ONLY TO DETECT FAILURE WHILE DEVELOPING
        Lokalise.addCallback(object: LokaliseCallback {
            override fun onUpdateFailed(error: LokaliseUpdateError) {
                logD(logContext, "callback onUpdateFailed: ${error.name}")
            }
            override fun onUpdateNotNeeded() { /* ignored */ }
            override fun onUpdated(oldBundleId: Long, newBundleId: Long) { /* ignored */ }
        })

        Lokalise.updateTranslations()
    }

    override fun lokalise(stringRef: String): String? = LokaliseResources(appContext).getString(stringRef)

    override fun loadResources() {
        LokaliseResources(appContext)
    }

    override fun changeLanguage(language: Language) = Lokalise.setLocale(language.isoCode, language.region)

    override fun geLokaliseLanguage(): Language {
        val isoCode = Locale.getDefault().language
        val region = Locale.getDefault().country
        return Language.getLanguageByIsoCodeAndRegion(isoCode,region)
    }
}