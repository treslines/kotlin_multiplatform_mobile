package br.com.progdeelite.kmmprogdeelite.settings

// IMPORTANTE: NO MAC, DESCOMENTA ISSO AQUI E REMOVE *)

//import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
//import platform.Foundation.NSUserDefaults

// val delegate: NSUserDefaults = NSUserDefaults.standardUserDefaults()
//actual fun getSettings(): Settings = NSUserDefaultsSettings(delegate)


// *) AQUI APENAS PARA PODER COMPILAR NO WINDOWS
actual fun getSettings(): Settings? = null // remove isso aqui quando descomentar o de cima!