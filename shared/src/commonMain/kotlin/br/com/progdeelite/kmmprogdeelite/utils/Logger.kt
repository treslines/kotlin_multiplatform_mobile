package br.com.progdeelite.kmmprogdeelite.utils

enum class LogType {
    DEBUG, ERROR, INFO, WARNING
}


object Logger: CommonLogger


fun logD(context: String, msg: String) {
    Logger.log("$context: $msg", LogType.DEBUG)
}

fun logE(context: String, msg: String) {
    Logger.log("$context: $msg", LogType.ERROR)
}

fun logI(context: String, msg: String) {
    Logger.log("$context: $msg", LogType.INFO)
}

fun logW(context: String, msg: String) {
    Logger.log("$context: $msg", LogType.WARNING)
}