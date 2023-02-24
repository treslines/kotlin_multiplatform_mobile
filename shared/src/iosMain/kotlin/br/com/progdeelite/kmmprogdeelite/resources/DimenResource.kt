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
){
    val roundedCorner: Double by lazy { roundedCornerUnit.toDouble() }
}

actual class DefaultPaddingsResource actual constructor(
    private val defaultStart: Int,
    private val defaultEnd: Int,
    private val defaultTop: Int,
    private val defaultBottom:Int
){
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