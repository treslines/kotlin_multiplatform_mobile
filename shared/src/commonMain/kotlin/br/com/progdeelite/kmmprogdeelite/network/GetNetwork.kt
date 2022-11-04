package br.com.progdeelite.kmmprogdeelite.network

import io.ktor.client.*

expect fun getAppEnvironment(): Environment
expect fun getHttpClient(clientConfig: ClientConfig): HttpClient