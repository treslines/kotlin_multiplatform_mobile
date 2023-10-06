package br.com.progdeelite.kmmprogdeelite.resources

import kotlin.native.concurrent.ThreadLocal

// 1) DEFINICÃO DA REGUA DAS CONTANTES
// 2) IMPLEMENTAçÃO ANDROID E IOS
// 3) INCORPORAçÃO NO RECURSO CENTRAL DE RESOURCES COMPARTILHADO
// 4) USO PRÁTICO NAS PLATAFORMAS

@ThreadLocal
object LayoutDimens {
    private val dimensions by lazy { ComponentDimens.Dimens() }
    internal fun getDimens(): ComponentDimens = dimensions
}

abstract class ComponentDimens(
    val button: ButtonDimensResource,
    val surface: SurfaceDimensResource,
    val textInputField: TextFieldDimensResource,
    val defaultPadding: DefaultPaddingsResource,
    val header: HeaderDimensResource,
    val screen: ScreenDimensResource,
    val card: CardDimensResource,
    val icon: IconDimensResource,
    val viewPager: ViewPagerResource
    // ... OUTROS COMPONENTES ADICIONE AQUI ....
) {
    internal class Dimens : ComponentDimens(
        button = ButtonDimensResource(20, 0, 44, 34),
        surface = SurfaceDimensResource(20),
        textInputField = TextFieldDimensResource(40, 54, 40),
        defaultPadding = DefaultPaddingsResource(12, 12, 12, 12),
        header = HeaderDimensResource(100, 45, 24, 0, 24, 12, 0.95f),
        screen = ScreenDimensResource(24, 0.1f, 100f, 20),
        card = CardDimensResource(15, 24, 56, 56),
        icon = IconDimensResource(24, 48),
        viewPager = ViewPagerResource(10, 10, 20)
    )
}

expect class HeaderDimensResource(
    defaultHeight: Int,
    defaultContentHeight: Int,
    defaultPaddingStart: Int,
    defaultPaddingTop: Int,
    defaultPaddingEnd: Int,
    defaultPaddingBottom: Int,
    defaultFakeBlurAlpha: Float
)

expect class ScreenDimensResource(defaultPadding: Int, defaultStatusBarThreshold: Float, defaultBlendLimit: Float, defaultCurveInset: Int)
expect class CardDimensResource(
    defaultCornerRadius: Int,
    defaultPadding: Int,
    defaultHeight: Int,
    defaultWidth: Int
)

expect class ViewPagerResource(
    defaultIndicatorComponentPadding: Int,
    defaultIndicatorPadding: Int,
    defaultIndicatorSize: Int,
)

expect class IconDimensResource(defaultTiny: Int, defaultNormal: Int)

expect class DefaultPaddingsResource(defaultStart: Int, defaultEnd: Int, defaultTop: Int, defaultBottom: Int)
expect class SurfaceDimensResource(roundedCornerUnit: Int)
expect class ButtonDimensResource(roundedCornerUnit: Int, minWidthUnit: Int, heightUnit: Int, smallHeightUnit: Int)
expect class TextFieldDimensResource(minWidthUnit: Int, minHeightUnit: Int, roundCornerUnit: Int)