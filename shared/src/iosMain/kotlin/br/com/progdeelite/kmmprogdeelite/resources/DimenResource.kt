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

actual class TextFieldDimensResource actual constructor(
    private val minWidthUnit: Int,
    private val minHeightUnit: Int,
    private val roundCornerUnit: Int
) {
    val minWidth: Double by lazy { minWidthUnit.toDouble() }
    val minHeight: Double by lazy { minHeightUnit.toDouble() }
    val roundCorner: Double by lazy { roundCornerUnit.toDouble() }
}