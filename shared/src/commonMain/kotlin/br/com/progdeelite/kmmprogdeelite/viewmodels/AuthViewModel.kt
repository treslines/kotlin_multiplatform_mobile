package br.com.progdeelite.kmmprogdeelite.viewmodels

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// 1) CRIAR VIEW MODELS DE LOGIN E REGISTRO
// 2) CRIAR EXTENSÃO PARA OBTER SCOPED VIEW MODELS
// 3) AJUSTAR BottomBarItem E Graphs
// 4) REFATORAR BottomBarConfigList

abstract class AuthViewModel : BaseSharedViewModel() {
    var startScreen: String? = null

    private val _errorMessage = MutableStateFlow("")
    val errorMessage: StateFlow<String>
        get() {
            return _errorMessage
        }

    abstract fun onConfirmOtp(confirmCode: String)

    protected fun emitErrorMsg(msg: String){
        scope.launch {
            _errorMessage.emit(msg)
        }
    }
}

class RegisterViewModel : AuthViewModel() {
    fun register(mobile: String, name: String, birthdate: String, email: String) {
        // seu_servico.signUp(mobile, name, birthdate, email)
    }

    override fun onConfirmOtp(confirmCode: String) {
        when{
            confirmCode.isNotEmpty() -> {} //seu_servico.confirmSignUp(mobile, confirmCode)
            confirmCode.isEmpty() -> emitErrorMsg("Insira códido SMS")
        }
    }
}

class LoginViewModel : AuthViewModel() {
    fun login(mobile: String) = "" // seu_servico.signIn(mobile)

    override fun onConfirmOtp(confirmCode: String) {
        when{
            confirmCode.isNotEmpty() -> {} // seu_servico.confirmSignIn(confirmCode)
            confirmCode.isEmpty() -> emitErrorMsg("Insira códido SMS")
        }
    }
}