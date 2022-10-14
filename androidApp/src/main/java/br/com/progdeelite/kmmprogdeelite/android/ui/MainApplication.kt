package br.com.progdeelite.kmmprogdeelite.android.ui

import android.app.Application
import android.content.Context
import br.com.progdeelite.utils.AndroidApplication

class MainApplication: Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        base?.let {
            // inject the application context into androidMain
            AndroidApplication.context = it
        }
    }
}