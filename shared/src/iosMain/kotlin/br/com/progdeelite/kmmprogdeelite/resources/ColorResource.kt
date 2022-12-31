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
 * iOS works only with RGB-values while android needs an HEX-Value. That's way we need to extend from [IosColor].
 * We pass value over to [IosColor] which takes an HEX-Value and extracts its RBG components making it available for iOS.
 */
actual class ColorResource actual constructor(colorHexValue: Long): IosColor(colorHexValue) {
    //fun getColor() = UIColor(red = r, blue = b, green = g, alpha = a)
}