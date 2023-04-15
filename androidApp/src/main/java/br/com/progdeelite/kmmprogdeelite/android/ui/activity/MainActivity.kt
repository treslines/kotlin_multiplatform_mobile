package br.com.progdeelite.kmmprogdeelite.android.ui.activity

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import br.com.progdeelite.kmmprogdeelite.android.R
import br.com.progdeelite.kmmprogdeelite.android.ui.components.*
import br.com.progdeelite.kmmprogdeelite.android.ui.navigation.RootNavigationGraph
import br.com.progdeelite.kmmprogdeelite.android.ui.screens.AnimationScreen
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.AndroidAppTheme
import br.com.progdeelite.kmmprogdeelite.android.utils.DependencyInjectionForPreview
import br.com.progdeelite.kmmprogdeelite.di.DI
import br.com.progdeelite.kmmprogdeelite.localization.DialogTexts
import br.com.progdeelite.kmmprogdeelite.resources.Resources
import br.com.progdeelite.kmmprogdeelite.utils.LoadingButtonState
import br.com.progdeelite.kmmprogdeelite.viewmodels.EntryViewModel
import br.com.progdeelite.kmmprogdeelite.viewmodels.MainActivityViewModel
import br.com.progdeelite.kmmprogdeelite.viewmodels.SampleViewModel
import br.com.progdeelite.kmmprogdeelite.viewmodels.ShimmerViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val model by viewModels<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // IMPORTANTE: PARA QUE COMPOSABLES INICIEM PARTINDO DA STATUS BAR E NÃO ABAIXO DELA
        // PORÉM FIQUE ATENTO QUE VOCÊ PRECISA COMPENSAR A ALTURA DA BARRA DE NAVEGAçÃO
        // DO SYSTEMA ANDROID NA SUA BOTTOM NAVIGATION BAR, CASO VC ESTEJA USANDO UMA VERSÃO
        // DE COMPOSE INFERIOR OU IGUAL = 1.1.1. DO CONTRARIO USE "Modifier.navigationBarsPadding"
        // VIDE: BottomNavigationBar ou Box(Modifier.navigationBarsPadding() ABAIXO
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Endereça auditoria de segurança: Hide Recent Thumbnails
        // window.addFlags(WindowManager.LayoutParams.FLAG_SECURE)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            // Endereça auditoria de segurança: Hide Multi-Windows Mode
            model.toggleHideThumbnailState(
                hide = isInMultiWindowMode || isInPictureInPictureMode
            )
        }

        val viewModel = SampleViewModel()
        val shimmerViewModel = ShimmerViewModel()
        val entryViewModel = EntryViewModel()

        Log.d("TESTANDO", DI.Native.environment.name)
        setContent {
            val hideThumbnail by model.hideThumbnail.collectAsState()

            AndroidAppTheme {
                Box(Modifier.navigationBarsPadding()){ // compose >= 1.2.1 to proper position bottomNavBar
                    if (hideThumbnail) {
                        Box(modifier = Modifier.fillMaxSize().background(Resources.Theme.background.getColor()))
                    } else {
                        // DatabaseVid(viewModel)
                        // ShimmerVid(shimmerViewModel)
                        // KtorVid(viewModel = entryViewModel)
                        // LoadingButtonVid()
                        // CustomDialogVid()
                        // ModalBottomSheetVid()
                        // DefaultBottomSheetVid()
                        // SplashWithLottieVid()
                        NavigationVid()
                    }
                }
            }
        }
    }
}

@Composable
fun NavigationVid() {
    RootNavigationGraph()
}

@Composable
private fun SplashWithLottieVid() {
    AnimationScreen(navController = rememberNavController())
}
@Composable
@OptIn(ExperimentalMaterialApi::class)
private fun ModalBottomSheetVid() {
    val bottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
    )

    val coroutineScope = rememberCoroutineScope()
    val onBottomSheetAction = {
        coroutineScope.launch {
            if (bottomSheetState.isVisible) bottomSheetState.hide() else bottomSheetState.show()
        }
    }

    ModalBottomSheet(
        title = "Título do BottomSheet",
        sheetState = bottomSheetState,
        parentContent = {
            DummyScreen(
                modifier = Modifier.background(
                    color = Color.LightGray
                ),
                name = "Exibir BottomSheet", onClick = { onBottomSheetAction() }
            )
        }
    ) {
        Text(text = "Conteúdo do BottomSheet")
    }
}

@Composable
@OptIn(ExperimentalMaterialApi::class)
private fun DefaultBottomSheetVid() {

    val sheet = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Expanded)
    )
    val coroutineScope = rememberCoroutineScope()
    val onBottomSheetAction = {
        coroutineScope.launch {
            if (sheet.bottomSheetState.isExpanded) {
                sheet.bottomSheetState.collapse()
            } else {
                sheet.bottomSheetState.expand()
            }
        }
    }

    BottomSheet(
        title = "Título do BottomSheet",
        scaffoldState = sheet,
        parentContent = {
            DummyScreen(
                modifier = Modifier.background(
                    color = Color.LightGray
                ),
                name = "Exibir DefaultBottomSheet", onClick = { onBottomSheetAction() }
            )
        }
    ) {
        Text(text = "Conteúdo do BottomSheet")
    }
}

@Composable
private fun CustomDialogVid() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        var showForceUpdateDialog by remember { mutableStateOf(false) }
        var showCancelDialog by remember { mutableStateOf(false) }

        Column(modifier = Modifier.padding(12.dp)) {
            if (showForceUpdateDialog) {
                CustomDialog(
                    dialogTexts = DialogTexts.ForceUpdate,
                    primaryButtonAction = { showForceUpdateDialog = false },
                    secondaryButtonAction = { showForceUpdateDialog = false }
                )
            }
            if (showCancelDialog) {
                CustomDialog(
                    dialogTexts = DialogTexts.Cancel,
                    primaryButtonAction = { showCancelDialog = false }
                )
            }
            PrimaryButton(
                text = "Atualizar App",
                onClick = {
                    showCancelDialog = false
                    showForceUpdateDialog = true
                }
            )
            Spacing.Normal()
            PrimaryButton(
                text = "Cancelar Cadastro",
                onClick = {
                    showForceUpdateDialog = false
                    showCancelDialog = true
                }
            )
        }
    }
}

@Composable
@OptIn(ExperimentalUnitApi::class)
private fun KtorVid(viewModel: EntryViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        val entries by viewModel.entries.collectAsState()
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = "Ktor Http-Request KMM", style = LocalTextStyle.current.copy(
                    fontSize = TextUnit(24f, TextUnitType.Sp)
                )
            )
            Row {
                Button(onClick = { viewModel.fetchEntries() }) {
                    Text(text = "Load Entries")
                }
            }

            entries?.forEach { entry ->
                Text(text = entry.description ?: "")
            }
        }
    }
}

@Composable
private fun ShimmerVid(shimmerViewModel: ShimmerViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {

        FullScreenMessageDialog(
            icon = R.drawable.ic_warning,
            iconTint = android.R.color.holo_red_light,
            title = "My Dialog",
            message = "This is my fancy body message!",
            bottomButtonText = "Toggle Shimmer",
            bottomButtonAction = { shimmerViewModel.toggleLoadingState() },
            loadingState = shimmerViewModel.loading
        )
    }
}

@Composable
private fun LoadingButtonVid() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        val activeState = MutableStateFlow(LoadingButtonState.ACTIVE)
        val disabledState = MutableStateFlow(LoadingButtonState.DISABLED)
        val loadingState = MutableStateFlow(LoadingButtonState.LOADING)
        Column(modifier = Modifier.padding(12.dp)) {
            LoadingButton(text = "Loading", loadingButtonState = activeState)
            Spacing.Normal()
            LoadingButton(text = "Loading", loadingButtonState = disabledState)
            Spacing.Normal()
            LoadingButton(text = "Loading", loadingButtonState = loadingState)
        }
    }
}

@Composable
@OptIn(ExperimentalUnitApi::class)
private fun DatabaseVid(viewModel: SampleViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        val stories by viewModel.stories.collectAsState()
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = "SqlDelight KMM", style = LocalTextStyle.current.copy(
                    fontSize = TextUnit(24f, TextUnitType.Sp)
                )
            )
            Row {
                Button(onClick = { viewModel.loadStories() }) {
                    Text(text = "Load Stories")
                }
                Spacer(modifier = Modifier.width(12.dp))
                Button(onClick = { viewModel.clearStories() }) {
                    Text(text = "Clear Stories")
                }
            }

            stories.forEach { story ->
                Text(text = story.name)
            }
        }
    }
}

@Composable
fun Greeting(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        Greeting("Hello, Android!")
    }
}
