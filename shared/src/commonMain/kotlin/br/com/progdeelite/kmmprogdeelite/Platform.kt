package br.com.progdeelite.kmmprogdeelite

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

