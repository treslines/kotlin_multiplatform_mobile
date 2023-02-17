package br.com.progdeelite.kmmprogdeelite.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.AndroidAppTheme
import br.com.progdeelite.kmmprogdeelite.android.utils.DependencyInjectionForPreview
import br.com.progdeelite.kmmprogdeelite.resources.Resources

@Composable
fun DummyScreen(
    modifier: Modifier = Modifier.background(MaterialTheme.colors.background),
    name: String,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = "", onValueChange = { {} },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Resources.Theme.backgroundSecondary.getColor(),
                textColor = MaterialTheme.colors.error,
            ),
            placeholder = {
                Text("Exibir teclado")
            }
        )
        Spacing.Big()
        PrimaryButton(text = name, onClick = onClick)
    }
}

@Preview
@Composable
fun ViewContentPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        DummyScreen(
            name = "Cadastrar",
            onClick = {}
        )
    }
}