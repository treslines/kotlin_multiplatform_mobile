package br.com.progdeelite.kmmprogdeelite.android.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.progdeelite.kmmprogdeelite.android.R
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.AndroidAppTheme
import br.com.progdeelite.kmmprogdeelite.android.utils.DependencyInjectionForPreview
import br.com.progdeelite.kmmprogdeelite.viewmodels.ShimmerViewModel
import com.valentinilk.shimmer.Shimmer
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer
import kotlinx.coroutines.flow.StateFlow

@Composable
fun FullScreenMessageDialog(
    @DrawableRes icon: Int? = null,
    @ColorRes iconTint: Int? = null,
    title: String,
    message: String,
    bottomButtonText: String,
    bottomButtonAction: () -> Unit = {},
    loadingState: StateFlow<Boolean>,
) {
    val loading by loadingState.collectAsState()
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
                val shimmerInstance = rememberShimmer(shimmerBounds = ShimmerBounds.Window)
                when {
                    loading -> MessageContentWithShimmer(shimmerInstance)
                    else -> MessageContent(icon, iconTint, title, message)
                }
            }
            BottomButton(
                Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .fillMaxWidth(),
                text = bottomButtonText,
                onClick = bottomButtonAction)
        }
    }
}

@Composable
fun MessageContent(
    @DrawableRes icon: Int? = null,
    @ColorRes iconTint: Int? = null,
    title: String,
    message: String,
) {
    icon?.let {
        Image(
            modifier = Modifier
                .width(70.dp)
                .height(70.dp),
            painter = painterResource(it),
            contentDescription = "",
            colorFilter = if(iconTint!=null) ColorFilter.tint(colorResource(iconTint)) else ColorFilter.tint(Color(0xFFBB86F5))
        )
    }
    Text(
        modifier = Modifier,
        text = title,
        textAlign = TextAlign.Center
    )
    Text(
        text = message,
        modifier = Modifier.padding(top = 16.dp, bottom = 36.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
fun MessageContentWithShimmer(
    shimmerInstance: Shimmer
) {

    Box(
        modifier = Modifier
            .shimmer(shimmerInstance)
            .width(70.dp)
            .height(70.dp)
            .background(color = Color(0xFFBB86F5)),
    )
    Spacer(
        modifier = Modifier
            .padding(top = 12.dp)
            .height(24.dp)
            .width(150.dp)
            .shimmer(shimmerInstance)
            .background(color = Color(0xFFBB86F5)),
    )
    Spacer(
        modifier = Modifier
            .padding(top = 16.dp, bottom = 36.dp)
            .height(24.dp)
            .width(150.dp)
            .shimmer(shimmerInstance)
            .background(color = Color(0xFFBB86F5))
    )
}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun FullScreenMessagePreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        FullScreenMessageDialog(
            icon = R.drawable.ic_warning,
            title = "Title",
            message = "Message",
            bottomButtonText = "OK",
            loadingState = ShimmerViewModel().loading
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun FullScreenMessagePreviewWithShimmer() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        // shimmer aplicado
        val viewModel = ShimmerViewModel().apply { toggleLoadingState() }
        FullScreenMessageDialog(
            icon = R.drawable.ic_warning,
            iconTint = androidx.appcompat.R.color.abc_primary_text_material_dark,
            title = "Title",
            message = "Message",
            bottomButtonText = "OK",
            loadingState = viewModel.loading
        )
    }
}