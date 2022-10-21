package br.com.progdeelite.kmmprogdeelite.viewmodels

import br.com.progdeelite.kmmprogdeelite.BaseSharedViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// 1) ADICIONAR DEPENDÊNCIAS & ADICIONAR AO BUILD.GRADLE
// 2) CRIAR DIALOG DE TELA CHEIA EXEMPLAR
// 3) CRIAR VIEW MODEL PARA ATIVAR O EFEITO DE SOMBRA (SHIMMER)
// 4) USAR NA PRÁTICA DENTRO DA MAIN ACTIVITY
class ShimmerViewModel: BaseSharedViewModel() {
    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean>
        get() = _loading

    fun toggleLoadingState() {
        scope.launch {
            _loading.emit(_loading.value.not())
        }
    }
}