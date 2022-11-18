package br.com.progdeelite.kmmprogdeelite.network

import br.com.progdeelite.kmmprogdeelite.network.models.ApiError

class YourCompanyException(
    message: String? = null,
    val apiError: ApiError? = null
): Exception(message)

suspend fun <T: Any> safeApiCall(apiCall: suspend () -> T): NetworkResult<T> {
    return try {
        NetworkResult.Success(data = apiCall.invoke())
    }
    catch (e: YourCompanyException){
        return mapYourCompanyException(e)
    }
    catch (e: Exception) {
        NetworkResult.Exception(e)
    }
}

fun <T> mapYourCompanyException(e: YourCompanyException): NetworkResult<T> {
    return NetworkResult.Error(
        code = e.apiError?.code ?: "0",
        errorMessage = e.apiError?.message ?: "Erro desconhecido!"
    )
}
