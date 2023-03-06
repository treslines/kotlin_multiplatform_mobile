package br.com.progdeelite.kmmprogdeelite.android.ui.components

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Switch
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// 1) LICÕES APRENDIDAS USANDO COMPOSE E OBSERVANDO ESTADOS
// 2) VIDEO SE BASEA NO POST DO TAKAHIRON:
// https://medium.com/@takahirom/jetpack-compose-state-guideline-494d467b6e76
// 3) VAMOS VER ALGUNS DON'Ts E DO's E ERROS TÍPICOS DE INICIANTES

// ❌ NÃO FACA ISSO
// POR QUE? - O ESTADO NÃO ESTA SENDO OBSERVADO E A ALTERACÃO NÃO OCORRE AO SER REDESENHADO
@Composable
fun MySwitch1() {
    // DEFINI UMA VARIÁVEL DE ESTADO DE CHECK.
    var checked = false
    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        }
    )
}

// ❌ NÃO FACA ISSO
// POR QUE? - O ESTADO NÃO ESTA SENDO LEMBRADO, JÁ QUE COMPOSE SEMPRE SE REDESENHA
@SuppressLint("UnrememberedMutableState")
@Composable
fun MySwitch2() {
    // DEFINI UMA VARIÁVEL DE ESTADO SEM USAR "remember{..}. - UnrememberedMutableState
    val checked =  mutableStateOf(false)
    Switch(
        checked = checked.value,
        onCheckedChange = {
            checked.value = it
        }
    )
}

// ❌ NÃO FACA ISSO
// POR QUE? - DÊ PREFERENCIA A DELEGACÃO DE PROPERTY USANDO "by"
@Composable
fun MySwitch3() {
    // DEFINI UMA VARIÁVEL DE ESTADO COM REMEMBER MAIS NÃO USEI "by"
    // EM KOTLIN EXISTE UMA FEATURE CHAMADA DELEGACÃO DE PROPERTY
    // QUE ELIMINA A NECESSIDADE DE LER O "value" TODAS AS VEZES
    // ENTÃO VAMOS USA-LO PARA UMA MELHOR LEGIBILIDADE
    val checked = remember { mutableStateOf(false) }
    Switch(
        checked = checked.value,
        onCheckedChange = {
            checked.value = it
        }
    )
}

// ❌ NÃO FACA ISSO
// POR QUE? - MUDANCAS DE ESTADO DEVEM OCORRER FORA DO CONTEXTO DO COMPOSABLE
@Composable
fun MySwitch4() {
    // AQUI ESSE COMPONENTE FICAR SE CHAMANDO INIFITAMENTE, POIS
    // ESTOU CHECANDO E MUDANDO SEU ESTADO DENTRO DO CONTEXTO DO COMPOSABLE
    // CONSEGUE ENXERGAR O PROBLEMA?
    var checked by remember { mutableStateOf(false) }
    checked = !checked
    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        }
    )
}

// PREFIRA STATE HOISTING
// POR QUE? - OS COMPONENTES FICAM REUSÁVEIS, TESTÁVEIS, AUMENTA
// A LEGIBILIDADE E PODEM SER EXIBIDOS FACILMENTE NAS PREVIEWS

@Composable
fun Screen1() {
    var checked by remember { mutableStateOf(false) }
    MySwitch5(checkState = checked, onCheckChanged = { checked = it })
}
@Composable
fun MySwitch5(checkState: Boolean, onCheckChanged: (Boolean) -> Unit) {
    Switch(
        checked = checkState,
        onCheckedChange = {
            onCheckChanged(it)
        }
    )
}

// MATENHA SEUS COMPONENTES STATELESS (SEMPRE QUE POSSIVEL)
// TENTE DIFERENCIAR OS COMPONENTES STATEFULL DOS STATELESS
// ASSIM ELES SÓ TEM ACESSO AO QUE REALMENTE IMPORTA PARA SEU CONTEXTO
// E PODEM ASSIM ALTERA APENAS O QUE LHES FOI CONCEDIDO. VOCE LEVANTA
// O ESTADO APENAS ATE O PARENTE MAIS COMUM ENTRE AMBOS. NÃO PASSE O
// VIEWMODEL INTEIRO PARA OS FILHOS.
//
// POR QUE? -  COMPONENTES Stateless
// PODEM SER TESTADOS E EXIBIDOS NA PREVIEW FACILMENTE

@Composable
fun Screen2() {
    var checked by remember { mutableStateOf(false) }
    MySwitch5(checkState = checked, onCheckChanged = { checked = it })
}
@Composable
fun MySwitch6(checkState: Boolean, onCheckChanged: (Boolean) -> Unit) {
    Switch(
        checked = checkState,
        onCheckedChange = {
            onCheckChanged(it)
        }
    )
}


// EVITE LÓGICA DE UI NOS COMPOSABLE E MOVA-LA PARA O UiStateHolder COMO REOMENDADO PELA GOOGLE
// https://developer.android.com/jetpack/compose/state#managing-state
//
//  - - The Composition  - -
// |  +------------+        |
// |  | Composable |        | UI elements
// |  +------------+        |
// |        |               |
// |  +---------------+     |
// |  | UiStateHolder |     | UI element's state
// |  +---------------+     | UI Logic
// |        |               |
//  - - - - - - - - - - - -
//          |
//    +------------+
//    | ViewModel  | Access to Business logic, Screen State
//    +------------+
//          |
//    +--------------------+
//    | Data/BusinessLayer | Business logic
//    +--------------------+
//

class SettingViewModel: ViewModel() {

    private val _isDarkMode = MutableStateFlow<Boolean>(false)
    val isDarkMode: StateFlow<Boolean>
        get() {
            return _isDarkMode
        }

    fun onDarkModeChange(changed: Boolean){
        if(_isDarkMode.value != changed){
            viewModelScope.launch {
                _isDarkMode.emit(!_isDarkMode.value)
            }
        }
    }
}

@Composable
fun SettingScreen(
    settingViewModel: SettingViewModel = viewModel(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    coroutinesScope: CoroutineScope = rememberCoroutineScope(),
) {
    val isDarkMode by settingViewModel.isDarkMode.collectAsState()
    SettingScreenContent(
        scaffoldState = scaffoldState,
        isDarkModeSetting = isDarkMode,
        onDarkModeSettingChanged = {
            settingViewModel.onDarkModeChange(it)
            coroutinesScope.launch {
                scaffoldState.snackbarHostState.showSnackbar("Dark mode changed!")
            }
        }
    )
}

@Composable
fun SettingScreenContent(
    isDarkModeSetting: Boolean,
    onDarkModeSettingChanged: (Boolean) -> Unit,
    scaffoldState: ScaffoldState
) {
    Scaffold(scaffoldState = scaffoldState) {
        MySwitch6(checkState = isDarkModeSetting, onCheckChanged = {
            onDarkModeSettingChanged(it)
        })
    }
}


@Composable
fun SettingScreen2(
    settingScreenState: SettingScreenState = rememberSettingScreenState()
) {
    SettingScreenContent2(
        scaffoldState = settingScreenState.scaffoldState,
        isDarkModeSetting = settingScreenState.isDarkMode,
        onDarkModeSettingChanged = {
            settingScreenState.onDarkModeChange(it)
        }
    )
}

@Composable
fun SettingScreenContent2(
    isDarkModeSetting: Boolean,
    onDarkModeSettingChanged: (Boolean) -> Unit,
    scaffoldState: ScaffoldState
) {
    Scaffold(scaffoldState = scaffoldState) {
        MySwitch6(checkState = isDarkModeSetting, onCheckChanged = {
            onDarkModeSettingChanged(it)
        })
    }
}

// SettingScreenState é o UiStateHolder.
// SettingScreenState é uma classe que não erda de nada
// é apenas para preservar o estado do elemento e não esta ligado a nenhum outro ciclo de vida.
class SettingScreenState(
    // Podemos ter aqui outros estados do elemento.
    val scaffoldState: ScaffoldState,
    // se voce precisar acessar logica de business ou da tela pai
    // o UiStateHolder também pode depender do view model.
    // isso não seria um problema pois o view model tem um
    // ciclo de vida superior ao do componente
    private val settingViewModel: SettingViewModel,
    private val coroutinesScope: CoroutineScope,
) {
    // as variabeis podem ser transformadas em composables se necessário sem problemas
    val isDarkMode: Boolean
        @Composable get() = settingViewModel.isDarkMode.collectAsState().value

    // a logica de negocio é movida para esta canto central
    fun onDarkModeChange(isDarkMode: Boolean) {
        settingViewModel.onDarkModeChange(isDarkMode)
        coroutinesScope.launch {
            scaffoldState.snackbarHostState.showSnackbar("Dark mode changed!", )
        }
    }
}

@Composable
fun rememberSettingScreenState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    coroutinesScope: CoroutineScope = rememberCoroutineScope(),
    settingViewModel: SettingViewModel = viewModel(),
) = remember {
    SettingScreenState(
        coroutinesScope = coroutinesScope,
        scaffoldState = scaffoldState,
        settingViewModel = settingViewModel
    )
}