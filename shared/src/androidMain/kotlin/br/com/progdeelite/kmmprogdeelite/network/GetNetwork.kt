package br.com.progdeelite.kmmprogdeelite.network

import br.com.progdeelite.kmmprogdeelite.utils.AndroidApp
import io.ktor.client.*

actual fun getAppEnvironment(): Environment = AndroidApp.environment
actual fun getHttpClient(clientConfig: ClientConfig): HttpClient = createOkHttpClient(clientConfig)