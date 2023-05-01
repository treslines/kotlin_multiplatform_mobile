package br.com.progdeelite.kmmprogdeelite.android.tracking.adobe

import android.app.Application
import br.com.progdeelite.kmmprogdeelite.tracking.adobe.AdobeAnalyticsSdk
import br.com.progdeelite.kmmprogdeelite.utils.logD
import br.com.progdeelite.kmmprogdeelite.utils.setLogLevelByBuildFlavor
import com.adobe.marketing.mobile.*

class AdobeAnalyticsSdkWrapper(app: Application) : AdobeAnalyticsSdk {

    private val logContext = "AdobeAnalyticsSdkWrapper"
    private val propertyMap: MutableMap<String, String> = mutableMapOf()

    init {
        // https://aep-sdks.gitbook.io/docs/using-mobile-extensions/adobe-analytics#register-analytics-with-mobile-core
        MobileCore.setApplication(app)
        setLogLevelByBuildFlavor(BuildConfig.FLAVOR) { MobileCore.setLogLevel(LoggingMode.DEBUG) }
        MobileCore.configureWithAppID("CommonConfig.ADOBE_APP_ID")

        try {
            Analytics.registerExtension()
            Identity.registerExtension()
            Lifecycle.registerExtension()
            MobileCore.start(null)
        } catch (e: InvalidInitException) {
            logD(logContext,"Could not initialize Adobe MobileCore: ${e.message}")
        }
    }

    override fun trackAction(name: String, contextData: Map<String, String>) {
        val combined = contextData.toMutableMap()
        combined.putAll(propertyMap)
        MobileCore.trackAction(name, combined)
    }

    override fun trackScreen(name: String, contextData: Map<String, String>?) {
        val combined = contextData?.toMutableMap() ?: mutableMapOf()
        combined.putAll(propertyMap)
        MobileCore.trackState(name, combined)
    }

    override fun setProperty(name: String, value: String) {
        propertyMap[name] = value
    }

    override fun unsetProperty(name: String) {
        when{
            propertyMap.containsKey(name) -> propertyMap.remove(name)
            else -> Unit
        }
    }
}