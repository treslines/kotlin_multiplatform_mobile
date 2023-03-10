package br.com.progdeelite.kmmprogdeelite.viewmodels

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// 1) COMO ENDERECAR ISSUE DE SEGURANçA APOS AUDITORIA
// 2) COMO PREVINIR QUE USUÁRO FACA PRINTSCREEN DO SEU APP (SEGURO/BANCARIO)
// 3) COMO EVITAR WORKAROUND ATRAVES DO MULTIWINDOW MODE

class MainActivityViewModel : BaseSharedViewModel() {

    // Endereça auditoria de segurança:
    // hide recent thumbnails plus multi-screen mode
    private val _hideThumbnail = MutableStateFlow(false)
    val hideThumbnail: StateFlow<Boolean>
        get() = _hideThumbnail

    fun toggleHideThumbnailState(hide: Boolean) {
        scope.launch {
            _hideThumbnail.emit(hide)
        }
    }
}