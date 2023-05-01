package br.com.progdeelite.kmmprogdeelite.viewmodels

import br.com.progdeelite.kmmprogdeelite.di.DI.inject
import br.com.progdeelite.kmmprogdeelite.network.*
import br.com.progdeelite.kmmprogdeelite.network.models.Entry
import br.com.progdeelite.kmmprogdeelite.repositories.EntryRepository
import br.com.progdeelite.kmmprogdeelite.utils.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EntryViewModel: BaseSharedViewModel() {

    private lateinit var storyRepository: EntryRepository
    private val logContext = "EntryViewModel"
    private val environment by inject<Environment>()

    private val _entries = MutableStateFlow<List<Entry>?>(null)
    val entries: StateFlow<List<Entry>?>
        get() {
            return _entries
        }
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?>
        get() {
            return _error
        }

    init {
        initEndPointService()
    }

    private fun initEndPointService() {
        val httpClient = getHttpClient(
            ClientConfig(
                environment = getAppEnvironment(), // VEJA AULA DE VARIAVEIS DE AMBIENTE
                userAgent = "Android"
            )
        )
        storyRepository = EntryRepository(ApiEndpoints(httpClient, getAppEnvironment()))
    }

    fun fetchEntries() {
        logD(logContext, "Meu ambiente é: ${environment.name}")
        scope.launch {
            storyRepository.fetchEntries().collect { result ->
                when(result){
                    is NetworkResult.Success -> _entries.emit(result.data).also {
                        logI(logContext, "Entries fetched successfully")
                    }
                    is NetworkResult.Error -> _error.emit(result.errorMessage).also{
                        logE(logContext,"Entries Error ${result.errorMessage}")
                    }
                    is NetworkResult.Exception -> _error.emit(result.exception?.message).also{
                        logE(logContext,"Entries Exception ${result.exception?.message}")
                    }
                }
            }
        }
    }
}








