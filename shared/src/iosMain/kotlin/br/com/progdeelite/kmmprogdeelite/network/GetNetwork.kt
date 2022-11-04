package br.com.progdeelite.kmmprogdeelite.network

import br.com.progdeelite.kmmprogdeelite.utils.IOSApp
import io.ktor.client.*
import io.ktor.client.engine.darwin.*

actual fun getAppEnvironment(): Environment = IOSApp.environment

actual fun getHttpClient(clientConfig: ClientConfig): HttpClient {
    return HttpClient(Darwin) {
        engine {
            configureRequest {
                //setAllowsCellularAccess(true)
            }
        }
    }
}