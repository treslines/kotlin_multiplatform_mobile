package br.com.progdeelite.kmmprogdeelite.utils

import android.util.Log
import br.com.progdeelite.kmmprogdeelite.BuildConfig

actual interface CommonLogger {
    actual fun log(message:String){
        // MAIS PARA FRENTE IREMOS USAR O ENVIRONMENT AQUI
        if(BuildConfig.DEBUG){
            Log.d(BuildConfig.BUILD_TYPE, message)
        }
    }
}