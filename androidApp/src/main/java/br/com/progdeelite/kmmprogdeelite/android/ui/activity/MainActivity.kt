package br.com.progdeelite.kmmprogdeelite.android.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import br.com.progdeelite.kmmprogdeelite.android.R
import br.com.progdeelite.kmmprogdeelite.android.ui.components.FullScreenMessageDialog
import br.com.progdeelite.kmmprogdeelite.android.ui.components.LoadingButton
import br.com.progdeelite.kmmprogdeelite.android.ui.components.Spacing
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.AndroidAppTheme
import br.com.progdeelite.kmmprogdeelite.android.utils.DependencyInjectionForPreview
import br.com.progdeelite.kmmprogdeelite.di.DI
import br.com.progdeelite.kmmprogdeelite.utils.LoadingButtonState
import br.com.progdeelite.kmmprogdeelite.viewmodels.EntryViewModel
import br.com.progdeelite.kmmprogdeelite.viewmodels.SampleViewModel
import br.com.progdeelite.kmmprogdeelite.viewmodels.ShimmerViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = SampleViewModel()
        val shimmerViewModel = ShimmerViewModel()
        val entryViewModel = EntryViewModel()

        Log.d("TESTANDO", DI.Native.environment.name)
        setContent {
            AndroidAppTheme {
                // DatabaseVid(viewModel)
                // ShimmerVid(shimmerViewModel)
                // KtorVid(viewModel = entryViewModel)
                LoadingButtonVid()
            }
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
