package br.com.progdeelite.kmmprogdeelite.network

import br.com.progdeelite.kmmprogdeelite.network.models.ApiError
import io.ktor.client.*
import io.ktor.client.call.*
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

// 0) ASSISTA A AULA ANTERIOR - PRE-REQUISITO
// 1) COMO CRIAR UM CUSTOM INTERCEPTOR
// 2) COMO MAPEAR O RESULTADO DO BACKEND (ApiError / SafeApiCall)
private fun HttpClientConfig<OkHttpConfig>.installResponseValidator() {
    HttpResponseValidator {
        validateResponse { response ->
            if(response.status != HttpStatusCode.OK){
                try {
                    val apiError = response.body<ApiError>()
                    throw YourCompanyException(message = "YourCompanyException", apiError= apiError)
                } catch (e: Throwable) {
                    throw Exception("${response.status}: ${response.body<String>()}", e)
                }
            }
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