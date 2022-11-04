package br.com.progdeelite.kmmprogdeelite.utils

import br.com.progdeelite.kmmprogdeelite.network.Environment

@ThreadLocal
object IOSApp {
    lateinit var environment: Environment
}