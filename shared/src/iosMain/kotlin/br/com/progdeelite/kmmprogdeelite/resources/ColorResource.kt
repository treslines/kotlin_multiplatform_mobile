package br.com.progdeelite.kmmprogdeelite.resources

// IMPORTANT: DESCOMENTA QUANTO TIVER NO MAC

//import platform.UIKit.UIColor
//import platform.UIKit.UITraitCollection
//import platform.UIKit.UIUserInterfaceStyle
//import platform.UIKit.currentTraitCollection

actual fun isSystemInDarkMode(): Boolean {
//    val mode = UITraitCollection.currentTraitCollection.userInterfaceStyle()
//    return mode == UIUserInterfaceStyle.UIUserInterfaceStyleDark
    return false
}

/**
 * iOS works only with RGB-values while android needs an HEX-Value. That's way we need [IosColor].
 * We pass value over to [IosColor] which takes an HEX-Value and extracts its RBG components making it available for iOS.
 */
actual class ColorResource actual constructor(light: Long, dark: Long) {
//    private val colorLight by lazy {
//        val rgb = IosColor(light)
//        UIColor(red = rgb.r, blue = rgb.b, green = rgb.g, alpha = rgb.a)
//    }
//
//    private val colorDark by lazy {
//        val rgb = IosColor(dark)
//        UIColor(red = rgb.r, blue = rgb.b, green = rgb.g, alpha = rgb.a)
//    }
//
//    val uiColor: UIColor
//        get() = if (isSystemInDarkMode()) colorDark else colorLight
//
//    /**
//     * iOS works only with RGB-values while android needs an HEX-Value. That's why we need to extend from [IosColor].
//     * We pass value over to IosColor which takes an HEX-Value and extracts its RBG components making it available for iOS.
//     */
//    private class IosColor(colorHexValue: Long) {
//        var r = 0.0
//        var g = 0.0
//        var b = 0.0
//        var a = 0.0
//
//        init {
//            a = ((colorHexValue shr 24) and 0xFF).toDouble() / 255
//            r = ((colorHexValue shr 16) and 0xFF).toDouble() / 255
//            g = ((colorHexValue shr 8) and 0xFF).toDouble() / 255
//            b = ((colorHexValue shr 0) and 0xFF).toDouble() / 255
//        }
//    }
}