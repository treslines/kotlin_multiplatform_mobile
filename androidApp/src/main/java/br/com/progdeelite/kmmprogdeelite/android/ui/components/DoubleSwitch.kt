package br.com.progdeelite.kmmprogdeelite.android.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.AndroidAppTheme
import br.com.progdeelite.kmmprogdeelite.android.utils.DependencyInjectionForPreview
import br.com.progdeelite.kmmprogdeelite.resources.Resources

@Composable
fun DoubleSwitch(
    startAtLeftPosition: Boolean = true,
    leftSwitchText: String,
    rightSwitchText: String,
    leftSwitchAction: () -> Unit = {},
    rightSwitchAction: () -> Unit = {},
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                color = Color(0x2e131313), // preto suave transparente
                shape = RoundedCornerShape(size = 60.dp) // arredondar as bordas
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        var switchState by remember { mutableStateOf(startAtLeftPosition) } // inicar no esquerdo ou direito

        val onLeftSwitchClicked = {
            leftSwitchAction() // Ações poderiam ser disparadas aqui
            switchState = true // controle do estado dos botões
        }
        val onRightSwitchClicked = {
            rightSwitchAction()
            switchState = false
        }

        Box {
            BackgroundComponent( // botões de trás
                leftSwitchText,
                rightSwitchText,
                onLeftSwitchClicked,
                onRightSwitchClicked
            )
            ForegroundComponent( // botões da frente
                switchState,
                leftSwitchText,
                rightSwitchText,
            )
        }
    }
}

@Composable
private fun ForegroundComponent(
    switchState: Boolean,
    textLeft: String,
    textRight: String,
) {
    val localDensity = LocalDensity.current
    var dynamicSpace by remember { mutableStateOf(0.dp) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(7.dp)
            .onGloballyPositioned { coordinates ->
                dynamicSpace = with(localDensity) {
                    coordinates.size.width.toDp() / 2
                }
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    )
    {
        if(switchState){
            SwitchButton(
                modifier = Modifier.width(dynamicSpace),
                text = textLeft,
                contentColor = Resources.Theme.backgroundPrimary.getColor(),
                backgroundColor = Color(0xffffffff),
            )
        }
        Spacer(Modifier.weight(1f))
        if(switchState.not()){
            SwitchButton(
                modifier = Modifier.width(dynamicSpace),
                text = textRight,
                contentColor = Resources.Theme.backgroundPrimary.getColor(),
                backgroundColor = Color(0xffffffff),
            )
        }
    }
}

@Composable
private fun BackgroundComponent(
    textLeft: String,
    textRight: String,
    onLeftSwitchClicked: () -> Unit,
    onRightSwitchClicked: () -> Unit,
) {
    val localDensity = LocalDensity.current
    var dynamicSpace by remember { mutableStateOf(0.dp) } // pulo do gato: tamanho dinâmico
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(7.dp)
            .onGloballyPositioned { coordinates ->
                dynamicSpace = with(localDensity) {
                    coordinates.size.width.toDp() / 2 // cada botão tera o mesmo tamanho
                }
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    )
    {
        SwitchButton(
            modifier = Modifier.width(dynamicSpace),
            text = textLeft,
            contentColor = Color(0xffffffff),
            backgroundColor = Resources.Theme.transparent.getColor(),
            onClick = onLeftSwitchClicked
        )
        Spacer(Modifier.weight(1f))
        SwitchButton(
            modifier = Modifier.width(dynamicSpace),
            text = textRight,
            contentColor = Color(0xffffffff),
            backgroundColor = Resources.Theme.transparent.getColor(),
            onClick = onRightSwitchClicked
        )
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO, showSystemUi = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
fun CustomSwitcherPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        Column {
            DoubleSwitch(
                leftSwitchText = "Contratos",
                rightSwitchText= "Ofertas",
            )
            Spacing.Normal()
            DoubleSwitch(
                leftSwitchText = "Detalhes",
                rightSwitchText= "Docomentos",
            )
            Spacing.Normal()
            DoubleSwitch(
                leftSwitchText = "Promoções",
                rightSwitchText= "Descontos",
            )
        }
    }
}