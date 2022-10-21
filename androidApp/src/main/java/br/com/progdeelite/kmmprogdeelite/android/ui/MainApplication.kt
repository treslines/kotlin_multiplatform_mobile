package br.com.progdeelite.kmmprogdeelite.android.ui

import android.app.Application
import android.content.Context
// import androidx.navigation.NavHostController // TODO: nav
import br.com.progdeelite.kmmprogdeelite.utils.AndroidApp

class MainApplication: Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        base?.let {
            // inject dependencies into androidMain
            AndroidApp.applicationContext = it
            // AndroidApp.navHostController = NavHostController(base) // TODO: nav
        }
    }
}