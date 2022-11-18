package br.com.progdeelite.kmmprogdeelite.repositories

import br.com.progdeelite.kmmprogdeelite.network.Endpoints
import br.com.progdeelite.kmmprogdeelite.network.NetworkResult
import br.com.progdeelite.kmmprogdeelite.network.models.Entry
import kotlinx.coroutines.flow.Flow

// 1) COMO CRIAR O REPOSITORY
// 2) COMO CRIAR O VIEWMODEL PARA EMITIR UM FLOW
// 3) COMO USAR O VIEWMODEL NA PRÁTICA DENTRO DA VIEW

interface EntrySourceType {
    suspend fun fetchEntries(): Flow<NetworkResult<List<Entry>>>
}

class EntryRepository(private val entryEndpoint: Endpoints.Entries): EntrySourceType {
    override suspend fun fetchEntries(): Flow<NetworkResult<List<Entry>>> {
        return entryEndpoint.getEntries()
    }
}