package br.com.progdeelite.kmmprogdeelite.android.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.*
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.AndroidAppTheme
import br.com.progdeelite.kmmprogdeelite.android.utils.DependencyInjectionForPreview
import br.com.progdeelite.kmmprogdeelite.resources.Resources

// 1) Adicionar cores novas no modulo de comum
// 2) Como criar textos anotáveis (AnnotatedText - que permitem highlight)
// 3) Como anotar(fazer o highlight de textos) e um compose

@Composable
fun SmsResendText(
    sendText: String = "Solicitar SMS novamente",
    resendText: String = "Próxima solicitação em {0}", // Esses textos vem das tradução, aqui apenas como exemplo!
    secondsText: String, // segundos restantes fornecido pelo componente pai
    style: TextStyle,
    disable: Boolean = false, // Para desabilita o campo, enquanto o count down esta andando
    onClick: () -> Unit = {}
) {
    val annotatedString = buildAnnotatedString {
        if (disable) {
            // Exemplo: Próxima solicitação em x
            withStyle(style = SpanStyle(Resources.Theme.labelDisabled.getColor())) { append(resendText.replace("{0}", "")) }
            withStyle(style = SpanStyle(Resources.Theme.labelDefault.getColor())) { append(secondsText) }
        } else {
            // Exemplo: Solicitar SMS novamente
            withStyle(style = SpanStyle(Resources.Theme.labelInteractive.getColor())) { append(sendText) }
        }
    }
    AnnotatedText(
        text = annotatedString,
        onClick = if (disable) {
            {}
        } else onClick,
        maxLines = 1,
        style = style
    )
}

@Composable
fun AnnotatedText(
    text: AnnotatedString,
    maxLines: Int,
    style: TextStyle = LocalTextStyle.current,
    onClick: () -> Unit = {}
) {
    Text(
        modifier = Modifier.clickable { onClick() },
        text = text,
        style = style,
        maxLines = maxLines, // considerando textos grandes
        overflow = TextOverflow.Ellipsis,
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showSystemUi = true, showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true, showBackground = true)
@Composable
fun TextsPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SmsResendText(
                style = LocalTextStyle.current,
                secondsText = "10"
            )
            Spacing.Big()
            SmsResendText(
                style = LocalTextStyle.current,
                secondsText = "10",
                disable = true
            )
        }
    }
}