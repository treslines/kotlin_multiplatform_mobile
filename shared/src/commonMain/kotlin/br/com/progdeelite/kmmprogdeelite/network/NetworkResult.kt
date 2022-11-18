package br.com.progdeelite.kmmprogdeelite.network

// ESTADO DA ARTE - SEGUE O CANAL, VC VAI PRECISAR DISSO!
sealed class NetworkResult<T>(
    val data: T? = null,
    val errorCode: String? = null,
    val errorMessage: String? = null,
    val exception: Throwable? = null
) {
    class Success<T>(data: T) : NetworkResult<T>(data)
    class Error<T>(code: String, errorMessage: String?) : NetworkResult<T>(
        errorCode = code,
        errorMessage = errorMessage
    )
    class Exception<T>(exception: Throwable?) : NetworkResult<T>(
        exception = exception
    )
}