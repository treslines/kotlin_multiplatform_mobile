package br.com.progdeelite.kmmprogdeelite.resources

actual class ButtonDimensResource actual constructor(
    private val roundedCornerUnit: Int,
    private val minWidthUnit: Int,
    private val heightUnit: Int,
    private val smallHeightUnit: Int
) {
    val roundedCorner: Double by lazy { roundedCornerUnit.toDouble() }
    val minWidth: Double by lazy { minWidthUnit.toDouble() }
    val height: Double by lazy { heightUnit.toDouble() }
    val smallHeight: Double by lazy { smallHeightUnit.toDouble() }
}

actual class SurfaceDimensResource actual constructor(
    private val roundedCornerUnit: Int
) {
    val roundedCorner: Double by lazy { roundedCornerUnit.toDouble() }
}

actual class HeaderDimensResource actual constructor(
    private val defaultHeight: Int,
    private val defaultContentHeight: Int,
    private val defaultPaddingStart: Int,
    private val defaultPaddingTop: Int,
    private val defaultPaddingEnd: Int,
    private val defaultPaddingBottom: Int,
    private val defaultFakeBlurAlpha: Float
) {
    val height: Double by lazy { defaultHeight.toDouble() }
    val contentHeight: Double by lazy { defaultContentHeight.toDouble() }
    val paddingStart: Double by lazy { defaultPaddingStart.toDouble() }
    val paddingTop: Double by lazy { defaultPaddingTop.toDouble() }
    val paddingEnd: Double by lazy { defaultPaddingEnd.toDouble() }
    val paddingBottom: Double by lazy { defaultPaddingBottom.toDouble() }
    val fakeBlurAlpha: Double by lazy { defaultFakeBlurAlpha.toDouble() }
}

actual class ScreenDimensResource actual constructor(
    private val defaultPadding: Int,
    private val defaultStatusBarThreshold: Float,
    private val defaultBlendLimit: Float,
    private val defaultCurveInset: Int
) {
    val padding: Double by lazy { defaultPadding.toDouble() }
    val statusBarThreshold: Double by lazy { defaultStatusBarThreshold.toDouble() }
    val blendLimit: Double by lazy { defaultBlendLimit.toDouble() }
    val curveInset: Double by lazy { defaultCurveInset.toDouble() }
}

actual class CardDimensResource actual constructor(
    private val defaultCornerRadius: Int,
    private val defaultPadding: Int
) {
    val cornerRadius: Double by lazy { defaultCornerRadius.toDouble() }
    val padding: Double by lazy { defaultPadding.toDouble() }
}

actual class IconDimensResource actual constructor(
    private val defaultTiny: Int,
    private val defaultNormal: Int
) {
    val tiny: Double by lazy { defaultTiny.toDouble() }
    val normal: Double by lazy { defaultNormal.toDouble() }
}

actual class DefaultPaddingsResource actual constructor(
    private val defaultStart: Int,
    private val defaultEnd: Int,
    private val defaultTop: Int,
    private val defaultBottom: Int
) {
    val start: Double by lazy { defaultStart.toDouble() }
    val end: Double by lazy { defaultEnd.toDouble() }
    val top: Double by lazy { defaultTop.toDouble() }
    val bottom: Double by lazy { defaultBottom.toDouble() }
}

actual class TextFieldDimensResource actual constructor(
    private val minWidthUnit: Int,
    private val minHeightUnit: Int,
    private val roundCornerUnit: Int
) {
    val minWidth: Double by lazy { minWidthUnit.toDouble() }
    val minHeight: Double by lazy { minHeightUnit.toDouble() }
    val roundCorner: Double by lazy { roundCornerUnit.toDouble() }
}