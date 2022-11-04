package br.com.progdeelite.kmmprogdeelite.viewmodels

import br.com.progdeelite.kmmprogdeelite.utils.CommonLogger
import br.com.progdeelite.kmmprogdeelite.utils.CommonLoggerImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// 1) ADICIONAR DEPENDÊNCIAS & ADICIONAR AO BUILD.GRADLE
// 2) CRIAR DIALOG DE TELA CHEIA EXEMPLAR
// 3) CRIAR VIEW MODEL PARA ATIVAR O EFEITO DE SOMBRA (SHIMMER)
// 4) USAR NA PRÁTICA DENTRO DA MAIN ACTIVITY
class ShimmerViewModel: BaseSharedViewModel() {

    private val _loading = MutableStateFlow(false)
    private val logger: CommonLogger = CommonLoggerImpl()

    val loading: StateFlow<Boolean>
        get() = _loading

    fun toggleLoadingState() {
        logger.log("Loading State Triggered!")
        scope.launch {
            _loading.emit(_loading.value.not())
        }
    }
}