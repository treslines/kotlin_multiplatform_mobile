package br.com.progdeelite.kmmprogdeelite.android.ui.components

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun WebViewScreen(
    webViewUrl: String, // passado como atributo na rota da tela anterior (tema pra outro video)
) {
    //val viewModel: WebViewModel = viewModel()

    val systemUiController = rememberSystemUiController()
    //systemUiController.setWebViewStatusBarColor()

    BackHandler(enabled = true) {
        //systemUiController.resetStatusBarColor()
        //viewModel.handleBackNavigation()
    }

    if (false/*viewModel.hasSeenWebViewConfirmationScreen()*/) {
        //systemUiController.resetStatusBarColor()
        //viewModel.onBackClicked()
    } else {
        //systemUiController.setWebViewStatusBarColor()
        WebViewContent(initialUrl = "", onUrlChanged = {})
    }
}

// 1) COMO USAR UMA WEB VIEW EM COMPOSE
// 2) COMO SABER PARA ONDE NAVEGAR DEPENDENDO DAS AçÕES DO USUÁRIO (HACK)
// 3) COMO CONTORNAR PROBLEMAS COM A STATUS BAR (BÔNUS)

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewContent(initialUrl: String, onUrlChanged: (String?) -> Unit) {

    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .statusBarsPadding(),
        factory = { context ->

            WebView(context).apply {
                // handle user interactions and scripts
                val webView = this
                webViewClient = object : WebViewClient() {
                    override fun doUpdateVisitedHistory(view: WebView?, url: String?, isReload: Boolean) {
                        onUrlChanged(url)
                        super.doUpdateVisitedHistory(view, url, isReload)
                    }
                }
                webView.settings.javaScriptEnabled = true // Needed for web view to work properly
                loadUrl(initialUrl)
            }
        })
}