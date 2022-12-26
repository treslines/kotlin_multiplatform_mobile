package br.com.progdeelite.kmmprogdeelite.localization

import android.annotation.SuppressLint
import android.content.res.Resources.NotFoundException
import br.com.progdeelite.kmmprogdeelite.utils.AndroidMainApp

@SuppressLint("DiscouragedApi")
actual fun getDefaultString(name: String): String {
    return with(AndroidMainApp.applicationContext) {
        try {
            getString(resources.getIdentifier(name, "string", packageName))
        } catch (ex: NotFoundException){
            name
        }
    }
}