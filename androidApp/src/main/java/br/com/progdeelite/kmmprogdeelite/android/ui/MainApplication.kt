package br.com.progdeelite.kmmprogdeelite.android.ui

import android.app.Application
import android.content.Context
import br.com.progdeelite.kmmprogdeelite.android.BuildConfig
import br.com.progdeelite.kmmprogdeelite.android.CommonConfig
import br.com.progdeelite.kmmprogdeelite.network.Environment
// import androidx.navigation.NavHostController // TODO: nav
import br.com.progdeelite.kmmprogdeelite.utils.AndroidApp

class MainApplication: Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        base?.let {
            // inject dependencies into androidMain
            AndroidApp.applicationContext = it
            setEnvironment()
        }
    }

    // APENAS PARA FINS DIDÁTICOS ASSIM. PARA MAIS DETALHES VEJA:
    // - https://developer.android.com/studio/build/build-variants#kts
    // - https://developer.android.com/studio/build
    private fun setEnvironment() {
        AndroidApp.environment = Environment.getEnvironmentByBuildFlavor(CommonConfig.FLAVOR)
    }
}