package br.com.progdeelite.kmmprogdeelite.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// VOCE JUNTO COM SEU BACKEND DEFINEM COMO O ERRO SERÁ RETORNADO
// AQUI UM EXEMPLO COMUM DE UM RETORNO DE UMA API DE UM BACKEND
@Serializable
data class ApiError(
    @SerialName("code")
    val code: String,
    @SerialName("message")
    val message: String
)
