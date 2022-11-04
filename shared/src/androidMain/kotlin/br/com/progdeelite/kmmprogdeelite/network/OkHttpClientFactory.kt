package br.com.progdeelite.kmmprogdeelite.network

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

fun createOkHttpClient(clientConfig: ClientConfig): HttpClient {
    return HttpClient(OkHttp) {
        installJsonSerializer()
        installRequestTimeouts()
        installDefaultUserAgentAndHeader(clientConfig)
        installResponseValidator()
    }
}

private fun HttpClientConfig<OkHttpConfig>.installResponseValidator() {
    HttpResponseValidator {
        validateResponse { response ->
            // TODO: próximos episódios - já segue para não perder!
        }
    }
}

@OptIn(ExperimentalSerializationApi::class)
fun HttpClientConfig<OkHttpConfig>.installJsonSerializer() {
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
            explicitNulls = false
        })
    }
}

private fun HttpClientConfig<OkHttpConfig>.installRequestTimeouts() {
    install(HttpTimeout) {
        requestTimeoutMillis = 10_000
        socketTimeoutMillis = 10_000
        connectTimeoutMillis = 10_000
    }
}

private fun HttpClientConfig<OkHttpConfig>.installDefaultUserAgentAndHeader(
    clientConfig: ClientConfig
) {
    defaultRequest {
        userAgent(clientConfig.userAgent)
    }
}