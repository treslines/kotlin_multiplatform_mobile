package br.com.progdeelite.kmmprogdeelite.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// 1) DEFINIR MODELOS DE CONTEUDO (EntryResponse)
// 2) DEFINIR MODELOS DE ERRO (ApiError)
// 3) CRIAR OS TIPOS DE RESULTADOS DA API (NetworkResult)
// 4) TRATAR/MAPEAR RESULTADOS DA API (SafeApiCall)
// 5) ESPECIFICAR ENDEREçO BASE DO ENDPOINT DENTRO DA VARIAVEL DE AMBIENTE (Environment)
// 6) ESPECIFICAR API ENDPOINTS (ApiEndpoints)



// COMO CRIEI ESSES OBJETOS?
// pesquisa: json to kotlin data class online generator
// https://json2kt.com/
@Serializable
data class EntryResponse(
    @SerialName("count") var count: Int? = null,
    @SerialName("entries") var entries: ArrayList<Entry> = arrayListOf()
)

@Serializable
data class Entry(
    @SerialName("API") var api: String? = null,
    @SerialName("Description") var description: String? = null,
    @SerialName("Auth") var auth: String? = null,
    @SerialName("HTTPS") var https: Boolean? = null,
    @SerialName("Cors") var cors: String? = null,
    @SerialName("Link") var link: String? = null,
    @SerialName("Category") var category: String? = null
)

