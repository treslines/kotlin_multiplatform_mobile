package br.com.progdeelite.kmmprogdeelite.utils

import android.util.Log
import br.com.progdeelite.kmmprogdeelite.di.DI
import br.com.progdeelite.kmmprogdeelite.network.Environment

actual interface CommonLogger {
    actual fun log(message:String, type: LogType){
        when (DI.Native.environment) {
            Environment.INT -> {
                val integration = Environment.INT.name
                when(type){
                    LogType.DEBUG -> Log.d(integration, message)
                    LogType.ERROR -> Log.e(integration, message)
                    LogType.INFO -> Log.i(integration, message)
                    LogType.WARNING -> Log.w(integration, message)
                }
            }
            Environment.DEV -> {
                val development = Environment.DEV.name
                when(type){
                    LogType.DEBUG -> Log.d(development, message)
                    LogType.ERROR -> Log.e(development, message)
                    LogType.INFO -> Log.i(development, message)
                    LogType.WARNING -> Log.w(development, message)
                }
            }
            else -> Unit
        }
    }
}