package br.com.progdeelite.kmmprogdeelite.utils

fun setLogLevelByBuildFlavor(buildFlavor: String, logLevel: () -> Unit) {
    when (buildFlavor) {
        "production" -> Unit
        "development" -> logLevel()
        "integration" -> logLevel()
        else -> Unit
    }
}