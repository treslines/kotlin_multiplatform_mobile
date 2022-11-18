package br.com.progdeelite.kmmprogdeelite.network

import br.com.progdeelite.kmmprogdeelite.network.models.Entry
import br.com.progdeelite.kmmprogdeelite.network.models.EntryResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

// SEU PONTO DE PARTIDA - SEGUE O CANALA PORQUE VC VAI PRECISAR CEDO OU TARDE!
interface Endpoints {
    interface Entries {
        suspend fun getEntries(): Flow<NetworkResult<List<Entry>>>
    }
    interface EndpointA
    interface EndpointB
    interface EndpointC
}

class ApiEndpoints(private val httpClient: HttpClient, private val env: Environment): Endpoints.Entries {

    override suspend fun getEntries(): Flow<NetworkResult<List<Entry>>> {
        val networkResult = safeApiCall {
            httpClient.get(urlString = "${env.hostTest}/random").body<EntryResponse>().entries.toList()
        }
        return flowOf(networkResult)
    }
}