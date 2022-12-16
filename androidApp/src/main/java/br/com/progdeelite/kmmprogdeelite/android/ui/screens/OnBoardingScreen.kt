package br.com.progdeelite.kmmprogdeelite.android.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.progdeelite.kmmprogdeelite.android.R
import br.com.progdeelite.kmmprogdeelite.android.ui.activity.AndroidAppTheme
import br.com.progdeelite.kmmprogdeelite.resources.getPreviewImageResource
import br.com.progdeelite.kmmprogdeelite.viewmodels.OnBoardingImages
import br.com.progdeelite.kmmprogdeelite.viewmodels.OnBoardingViewModel

@Composable
fun OnBoardingScreen(
    viewModel: OnBoardingViewModel
) {
    Surface {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxHeight(),
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(state = rememberScrollState())
                    .weight(weight = 1f, fill = true)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = viewModel.images.topImage.id),
                    contentDescription = ""
                )
                Text("Hello Compose")
                Image(
                    painter = painterResource(id = viewModel.images.middleImage.id),
                    contentDescription = ""
                )
                Text("Eu consigo me")
                Image(
                    painter = painterResource(id = viewModel.images.bottomImage.id),
                    contentDescription = ""
                )
                Text("renderizar assim!")
            }
        }
    }
}

@Preview
@Composable
fun OnBoardingPreview() {
    AndroidAppTheme {
        Column {
            OnBoardingScreen(
                viewModel = OnBoardingViewModel(
                    images = OnBoardingImages(
                        topImage = getPreviewImageResource(R.drawable.ic_warning),
                        middleImage = getPreviewImageResource(R.drawable.ic_warning),
                        bottomImage = getPreviewImageResource(R.drawable.ic_warning)
                    )
                )
            )
        }
    }
}