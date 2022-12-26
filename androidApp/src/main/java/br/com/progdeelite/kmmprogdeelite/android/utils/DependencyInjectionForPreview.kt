package br.com.progdeelite.kmmprogdeelite.android.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import br.com.progdeelite.kmmprogdeelite.di.DI
import br.com.progdeelite.kmmprogdeelite.utils.AndroidMainApp

@Composable
fun DependencyInjectionForPreview() {
    AndroidMainApp.applicationContext = LocalContext.current.applicationContext
    DI.fake()
}