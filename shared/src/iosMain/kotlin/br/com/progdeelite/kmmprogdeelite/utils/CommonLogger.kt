package br.com.progdeelite.kmmprogdeelite.utils

//import platform.Foundation.NSLog

actual interface CommonLogger {
    actual fun log(message:String){
        // MAIS PARA FRENTE IREMOS USAR O ENVIRONMENT AQUI
        if(Platform.isDebugBinary){
           //NSLog("\\%\\@: $message", "DEBUG")
        }
    }
}