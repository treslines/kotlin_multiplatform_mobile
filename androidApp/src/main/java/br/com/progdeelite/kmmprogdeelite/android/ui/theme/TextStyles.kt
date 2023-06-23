package br.com.progdeelite.kmmprogdeelite.android.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.FontTypes.ttNormsBold
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.FontTypes.ttNormsMedium
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.FontTypes.ttNormsRegular
import br.com.progdeelite.kmmprogdeelite.resources.FontSizingResource
import br.com.progdeelite.kmmprogdeelite.resources.Resources

// 1) COMO DEFINIR A FONT SIZES COMPARTILHADAS
// 2) COMO CRIAR ESTILOS CUSTOMIZADOS
// 3) COMO REUSAR ESTILOS
// 4) COMO ATRIBUIR OS ESTILOS NA TYPOGRAPHY E NO TEMA

// USANDO OS ESTILOS PERSONALIZADOS NA TIPOGRAFIA DO ANDROID
val typography = Typography(
    defaultFontFamily = ttNormsRegular.toFontFamily(),
    h1 = TextStyles.h1,
    h2 = TextStyles.h2,
    h3 = TextStyles.h3,
    h4 = TextStyles.h4,
    h5 = TextStyles.h5,
    h6 = TextStyles.h6,
//    subtitle1 = TextStyles.subtitle1,
//    subtitle2 = TextStyles.subtitle2,
    body1 = TextStyles.body1,
    body2 = TextStyles.body2,
    button = TextStyles.button,
//    caption = TextStyles.caption,
//    overline = TextStyles.overline
)

// 2) CRIANDO NOSSOS ESTILOS PERSONALIZADOS
// DEFINIçOES DO ANDROID NAO ATENDE A TODOS OS NOSSOS CASOS
object TextStyles {
    val h1 = TextStyleDefinitions.Bold.XXL
    val h2 = TextStyleDefinitions.Bold.XL
    val h3 = TextStyleDefinitions.Bold.L
    val h4 = TextStyleDefinitions.Bold.M
    val h5 = TextStyleDefinitions.Bold.S
    val h6 = TextStyleDefinitions.Bold.T
    val body1 = TextStyleDefinitions.Medium.L
    val body2 = TextStyleDefinitions.Bold.M
    val description = TextStyleDefinitions.Regular.Base
    val button = TextStyleDefinitions.Bold.Base
    val smallButton = TextStyleDefinitions.Bold.S
    val navBarItem = TextStyleDefinitions.Medium.T
    val textFieldSms = TextStyleDefinitions.Medium.S
    val textField = TextStyleDefinitions.Regular.M
    val textFieldHint = TextStyleDefinitions.Medium.S
}

// 1) DEFINICAO DOS ESTILOS DO SEU CLIENTE (TIME UI/UX DO FIGMA OU ZEPELLIN ETC.)
abstract class TextStyleDefinitions(
    val XXL: TextStyle,
    val XL: TextStyle,
    val L: TextStyle,
    val M: TextStyle,
    val S: TextStyle,
    val T: TextStyle,
    val Base: TextStyle,
) {

    // 1.1) DEFINIR METODOS AUXILIARES PARA NAO NOS REPETIR
    companion object {
        fun getBoldTextStyle(
            fontSizing: FontSizingResource,
            maxFontSize: FontSizingResource = Resources.FontSizing.huge
        ): TextStyle = TextStyle(
            fontFamily = ttNormsBold.toFontFamily(),
            fontWeight = ttNormsBold.weight,
            fontStyle = ttNormsBold.style,
            fontSize = minOf(fontSizing.size, maxFontSize.size),
            lineHeight = fontSizing.lineHeight
        )

        fun getMediumTextStyle(
            fontSizing: FontSizingResource,
            maxFontSize: FontSizingResource = Resources.FontSizing.huge
        ): TextStyle = TextStyle(
            fontFamily = ttNormsMedium.toFontFamily(),
            fontWeight = ttNormsMedium.weight,
            fontStyle = ttNormsMedium.style,
            fontSize = minOf(fontSizing.size, maxFontSize.size),
            lineHeight = fontSizing.lineHeight
        )

        fun getRegularTextStyle(
            fontSizing: FontSizingResource,
            maxFontSize: FontSizingResource = Resources.FontSizing.huge
        ): TextStyle = TextStyle(
            fontFamily = ttNormsRegular.toFontFamily(),
            fontWeight = ttNormsRegular.weight,
            fontStyle = ttNormsRegular.style,
            fontSize = minOf(fontSizing.size, maxFontSize.size),
            lineHeight = fontSizing.lineHeight
        )

        private  fun minOf(a: TextUnit, b: TextUnit): TextUnit {
            return if (a > b) b else a
        }
    }

    // 1.2) DEFINIR ESTILOS CONCRETOS
    object Bold : TextStyleDefinitions(
        // USANDO O METODO DE BOLD
        XXL = getBoldTextStyle(fontSizing = Resources.FontSizing.huge),
        XL = getBoldTextStyle(fontSizing = Resources.FontSizing.large),
        L = getBoldTextStyle(fontSizing = Resources.FontSizing.big),
        M = getBoldTextStyle(fontSizing = Resources.FontSizing.medium),
        S = getBoldTextStyle(fontSizing = Resources.FontSizing.small),
        T = getBoldTextStyle(fontSizing = Resources.FontSizing.tiny),
        Base = getBoldTextStyle(fontSizing = Resources.FontSizing.normal)
    )

    object Medium : TextStyleDefinitions(
        // USANDO O METODO DE MEDIUM
        XXL = getMediumTextStyle(fontSizing = Resources.FontSizing.huge),
        XL = getMediumTextStyle(fontSizing = Resources.FontSizing.large),
        L = getMediumTextStyle(fontSizing = Resources.FontSizing.big),
        M = getMediumTextStyle(fontSizing = Resources.FontSizing.medium),
        S = getMediumTextStyle(fontSizing = Resources.FontSizing.small),
        T = getBoldTextStyle(fontSizing = Resources.FontSizing.tiny),
        Base = getMediumTextStyle(fontSizing = Resources.FontSizing.normal)
    )

    object Regular : TextStyleDefinitions(
        // USANDO O METODO DE REGULAR
        XXL = getRegularTextStyle(fontSizing = Resources.FontSizing.huge),
        XL = getRegularTextStyle(fontSizing = Resources.FontSizing.large),
        L = getRegularTextStyle(fontSizing = Resources.FontSizing.big),
        M = getRegularTextStyle(fontSizing = Resources.FontSizing.medium),
        S = getRegularTextStyle(fontSizing = Resources.FontSizing.small),
        T = getBoldTextStyle(fontSizing = Resources.FontSizing.tiny),
        Base = getRegularTextStyle(fontSizing = Resources.FontSizing.normal)
    )
}