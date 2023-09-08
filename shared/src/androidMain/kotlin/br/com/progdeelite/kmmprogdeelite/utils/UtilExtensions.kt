package br.com.progdeelite.kmmprogdeelite.utils

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import kotlinx.serialization.encodeToString as jsonEncoder
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

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
fun parseData(data: String): String {
    // you need this to ensure proper navigation when passing arguments to routes
    // if there are some special chars, urls etc. the navigation will crash
    return URLEncoder.encode(data, StandardCharsets.UTF_8.toString())
}

// 0) DEPENDÊNCIAS QUE PRECISAREMOS
// 1) COMO CRIAR EXTENSÃO QUE VERIFICA SE DATA ESTA EXPIRADA
// 2) COMO OBTER O TEMPO (TIME) CORRENTE
// 3) COMO OBTER A DATA ATUAL E COMO FORMATA-LA

// returns current date time
fun nowLocalDateTime(): LocalDateTime {
    val now: Instant = Clock.System.now()
    return now.toLocalDateTime(TimeZone.currentSystemDefault())
}

// checks if today is bigger than this time
fun LocalDate.isExpired() = this.now().compareTo(this) > 1

// returns today's date
fun LocalDate.now(): LocalDate {
    val now: Instant = Clock.System.now()
    return now.toLocalDateTime(TimeZone.currentSystemDefault()).date
}

// With leading zeros
fun LocalDate.toDayMonthYear(): String {
    val dayWithLeadingZero = if (this.dayOfMonth.toString().length < 2) "0${this.dayOfMonth}" else this.dayOfMonth
    val monthWithLeadingZero = if (this.monthNumber.toString().length < 2) "0${this.monthNumber}" else this.monthNumber
    return "$dayWithLeadingZero.$monthWithLeadingZero.${this.year}"
}