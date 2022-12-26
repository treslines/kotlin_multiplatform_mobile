package br.com.progdeelite.kmmprogdeelite.network

import br.com.progdeelite.kmmprogdeelite.di.DI
import io.ktor.client.*

actual fun getAppEnvironment(): Environment = DI.Native.environment
actual fun getHttpClient(clientConfig: ClientConfig): HttpClient = createOkHttpClient(clientConfig)