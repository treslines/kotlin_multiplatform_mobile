package br.com.progdeelite.kmmprogdeelite.utils

//import platform.Foundation.NSLog
//import br.com.progdeelite.kmmprogdeelite.di.DI
//import br.com.progdeelite.kmmprogdeelite.network.Environment

actual interface CommonLogger {

    actual fun log(message: String, type: LogType) {
//        when (DI.Native.environment) {
//            Environment.INT -> {
//                when(type){
//                    LogType.DEBUG -> NSLog("Debug: $message - ${Environment.INT.name}")
//                    LogType.ERROR -> NSLog("Error: $message - ${Environment.INT.name}")
//                    LogType.INFO -> NSLog("Info: $message - ${Environment.INT.name}")
//                    LogType.WARNING -> NSLog("Warning: $message - ${Environment.INT.name}")
//                }
//            }
//            Environment.DEV -> {
//                when(type){
//                    LogType.DEBUG -> NSLog("Debug: $message - ${Environment.DEV.name}")
//                    LogType.ERROR -> NSLog("Error: $message - ${Environment.DEV.name}")
//                    LogType.INFO -> NSLog("Info: $message - ${Environment.DEV.name}")
//                    LogType.WARNING -> NSLog("Warning: $message - ${Environment.DEV.name}")
//                }
//            }
//            else -> Unit
//        }
    }
}