package br.com.progdeelite.kmmprogdeelite.android.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.progdeelite.kmmprogdeelite.resources.Resources.Spacing

// 1) COMO CUSTOMIZAR SPACERS
// 2) COMO USAR O SPACING COMPARTILHADO
// 3) OUTRA FORMA ALTERNATIVA PARA VC DECIDIR QUAL USAR

object Spacer {

    @Composable
    fun Tiny() {
        Spacer(modifier = Modifier.height(Spacing.tiny.dp))
    }

    @Composable
    fun ExtraSmall() {
        Spacer(modifier = Modifier.height(Spacing.extraSmall.dp))
    }

    @Composable
    fun Small() {
        Spacer(modifier = Modifier.height(Spacing.small.dp))
    }

    @Composable
    fun Normal() {
        Spacer(modifier = Modifier.height(Spacing.normal.dp))
    }

    @Composable
    fun Medium() {
        Spacer(modifier = Modifier.height(Spacing.medium.dp))
    }

    @Composable
    fun Big() {
        Spacer(modifier = Modifier.height(Spacing.big.dp))
    }

    @Composable
    fun ExtraBig() {
        Spacer(modifier = Modifier.height(Spacing.extraBig.dp))
    }

    @Composable
    fun Large() {
        Spacer(modifier = Modifier.height(Spacing.large.dp))
    }

    @Composable
    fun ExtraLarge() {
        Spacer(modifier = Modifier.height(Spacing.extraLarge.dp))
    }

    @Composable
    fun Huge() {
        Spacer(modifier = Modifier.height(Spacing.huge.dp))
    }

    @Composable
    fun ExtraHuge() {
        Spacer(modifier = Modifier.height(Spacing.extraHuge.dp))
    }
}


//@Composable
//fun SpacerNoSpace() {
//    Spacer(modifier = Modifier.height(MaterialTheme.spacing.noSpace))
//}

//@Composable
//fun SpacerTiny() {
//    Spacer(modifier = Modifier.height(MaterialTheme.spacing.tiny))
//}
//
//@Composable
//fun SpacerExtraSmall() {
//    Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraSmall))
//}
//
//@Composable
//fun SpacerSmall() {
//    Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
//}
//
//@Composable
//fun SpacerNormal() {
//    Spacer(modifier = Modifier.height(MaterialTheme.spacing.normal
//    ))
//}
//
//@Composable
//fun SpacerMedium() {
//    Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
//}
//
//@Composable
//fun SpacerBig() {
//    Spacer(modifier = Modifier.height(MaterialTheme.spacing.big))
//}
//
//@Composable
//fun SpacerExtraBig() {
//    Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraBig))
//}
//
//@Composable
//fun SpacerLarge() {
//    Spacer(modifier = Modifier.height(MaterialTheme.spacing.large))
//}
//
//@Composable
//fun SpacerExtraLarge() {
//    Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraLarge))
//}
//
//@Composable
//fun SpacerHuge() {
//    Spacer(modifier = Modifier.height(MaterialTheme.spacing.huge))
//}
//
//@Composable
//fun SpacerExtraHuge() {
//    Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraHuge))
//}