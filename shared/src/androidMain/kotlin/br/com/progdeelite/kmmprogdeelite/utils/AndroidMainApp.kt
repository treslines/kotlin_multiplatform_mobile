package br.com.progdeelite.kmmprogdeelite.utils

import android.annotation.SuppressLint
import android.content.Context

// Parte 1
// 1) https://plugins.jetbrains.com/plugin/8191-sqldelight
// 2) definir dependencies no modulo de buildSrc
// 3) referênciar dependencias nos build.gradles
// 4) Criar classes de applications
// 5) Criar modelos do banco em pacote models
// 6) Configurar sqldelight no build.gradle
// 7) Criar estrutura pacote database em common (seguir convenção sqldelight )
// 8) Criar Schema do banco de dados em database
// 9) especificar drivers de plataforma e definir scheme database, alisar o elefante
// 10) Criar classe de database em common em "sqldelight" no ROOT (muito importante)
// 11) Usar database em DataSourceProvider

// Parte 2
// 12) Usar DataSourceProvider no view model
// 13) Criar flow no view model para compose
// 14) Usar flow na main activity em compose
// 15) Criar teste para o banco de dados

// mais resources:
// https://bugonsoftware.substack.com/
// https://play.kotlinlang.org/hands-on/Networking%20and%20Data%20Storage%20with%20Kotlin%20Multiplatfrom%20Mobile/01_Introduction

@SuppressLint("StaticFieldLeak")
object AndroidMainApp {
    // since we are using the applicationContext and not
    // the context per se, nothing is going to leak here
    lateinit var applicationContext: Context
}