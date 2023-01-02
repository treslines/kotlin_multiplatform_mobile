package br.com.progdeelite.kmmprogdeelite.settings

import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import br.com.progdeelite.kmmprogdeelite.utils.AndroidMainApp
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings

// Creates a shared prefs with name: {context.getPackageName() + "_preferences"} and MODE_PRIVATE
val delegate: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(AndroidMainApp.applicationContext)

actual fun getSettings(): Settings? {
    return SharedPreferencesSettings(delegate)
}