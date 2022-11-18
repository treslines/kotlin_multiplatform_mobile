package br.com.progdeelite.kmmprogdeelite.android.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import br.com.progdeelite.kmmprogdeelite.android.R
import br.com.progdeelite.kmmprogdeelite.android.ui.components.FullScreenMessageDialog
import br.com.progdeelite.kmmprogdeelite.utils.AndroidApp
import br.com.progdeelite.kmmprogdeelite.viewmodels.EntryViewModel
import br.com.progdeelite.kmmprogdeelite.viewmodels.SampleViewModel
import br.com.progdeelite.kmmprogdeelite.viewmodels.ShimmerViewModel

@Composable
fun AndroidAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) {
        darkColors(
            primary = Color(0xFFBB86F5),
            primaryVariant = Color(0xFF3700B3),
            secondary = Color(0xFF03DAC5)
        )
    } else {
        lightColors(
            primary = Color(0xFF6200EE),
            primaryVariant = Color(0xFF3700B3),
            secondary = Color(0xFF03DAC5)
        )
    }
    val typography = Typography(
        body1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = SampleViewModel()
        val shimmerViewModel = ShimmerViewModel()
        val entryViewModel = EntryViewModel()

        Log.d("TESTANDO", AndroidApp.environment.name)
        setContent {
            AndroidAppTheme {
                // DatabaseVid(viewModel)
                // ShimmerVid(shimmerViewModel)
                KtorVid(viewModel = entryViewModel)
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
    AndroidAppTheme {
        Greeting("Hello, Android!")
    }
}
