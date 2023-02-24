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
    val defaultPadding: DefaultPaddingsResource
    // ... OUTROS COMPONENTES ADICIONE AQUI ....
) {
     internal class Dimens : ComponentDimens(
         button = ButtonDimensResource(20, 0, 44, 34),
         surface = SurfaceDimensResource(20),
         textInputField = TextFieldDimensResource(40, 54, 40),
         defaultPadding = DefaultPaddingsResource(12, 12, 12, 12)
    )
}

expect class DefaultPaddingsResource(defaultStart: Int, defaultEnd: Int, defaultTop: Int, defaultBottom:Int)
expect class SurfaceDimensResource(roundedCornerUnit: Int)
expect class ButtonDimensResource(roundedCornerUnit: Int, minWidthUnit: Int, heightUnit: Int, smallHeightUnit: Int)
expect class TextFieldDimensResource(minWidthUnit: Int, minHeightUnit: Int, roundCornerUnit: Int)