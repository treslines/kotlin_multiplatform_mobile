package br.com.progdeelite.kmmprogdeelite.utils

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import kotlinx.serialization.encodeToString as jsonEncoder

// 0) DEPENDÊNCIAS QUE PRECISAREMOS
// 1) COMO SERIALIZAR E DESERIALIZAR OBJETOS
// 2) COMO CRIAR UMA EXTENSÃO PARA USAR ONDE QUISER
// 3) BÔNUS: CUIDADOS QUE DEVEMOS TER AO PASSAR ARGUMENTOS PARA ROTAS

@kotlinx.serialization.Serializable
data class ToBeEncoded(val name: String)

fun ToBeEncoded.toJsonString(): String? = asJsonString()

private inline fun <reified T> T.asJsonString(): String? {
    return try {
        return Json.jsonEncoder(this)
    } catch (ex: Exception) {
        Logger.log("Json Encoding Exception: ${ex.message}", LogType.ERROR)
        null
    }
}

// funcão utilitária para quando os valores vem por algum motivo prefixados com aspas duplas
fun JsonObject.string(name: String) = this[name].toString().replace("\"", "")

val jsonBuilder = Json {
    this.ignoreUnknownKeys = true
    this.coerceInputValues = true
}

inline fun <reified T> String.toObject(): T? {
    return try {
        return jsonBuilder.decodeFromString(this)
    } catch (ex: Exception) {
        Logger.log("Json Decoding Exception: ${ex.message}", LogType.ERROR)
        null
    }
}

// BÔNUS - NAVEGACão
private fun parseData(data: String): String {
    // you need this to ensure proper navigation when passing arguments to routes
    // if there are some special chars, urls etc. the navigation will crash
    return URLEncoder.encode(data, StandardCharsets.UTF_8.toString())
}