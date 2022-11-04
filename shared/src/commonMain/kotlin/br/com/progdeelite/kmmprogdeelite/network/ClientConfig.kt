package br.com.progdeelite.kmmprogdeelite.network

// 1) CRIAR CLIENT CONFIG
// 2) COMO CRIAR O CLIENT HTTP
// 3) COMO CRIAR O OK_HTTP CLIENT FACTORY

/**
 * Client configuration to be applied whenever a HttpClient is created
 */
data class ClientConfig(
    /** To be used as environment switcher */
    val environment: Environment,

    /** To be used while sending requests "MOBILE", "WEB" or any other identifier you define */
    var userAgent: String
)