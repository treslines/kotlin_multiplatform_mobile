package br.com.progdeelite.kmmprogdeelite.resources

// 1) Adicionar dependencia
// 2) Definir expecte/actuals
// 3) implementar em android e iOS
// 4) implementar ColorResources
// 5) disponibilizar em Resources

/**
 * Indicates whether the app is using dark mode or not
 */
expect fun isSystemInDarkMode(): Boolean

/**
 * iOS can handle only RGB-values to create its color instances. That's why we offered the abstract class [IosColor].
 * It is intended to be used by iOS only. Android on the other hand must resolve its reference first. For that reason
 * we offer a color resolver method for android only in its actual implementation.
 */
expect class ColorResource(colorHexValue: Long): IosColor

/**
 * iOS works only with RGB-values while android needs an HEX-Value. That's why we need to extend from [IosColor].
 * We pass value over to IosColor which takes an HEX-Value and extracts its RBG components making it available for iOS.
 */
abstract class IosColor(colorHexValue: Long) {
    var r = 0.0
    var g = 0.0
    var b = 0.0
    var a = 0.0

    init {
        a = ((colorHexValue shr 24) and 0xFF).toDouble() / 255
        r = ((colorHexValue shr 16) and 0xFF).toDouble() / 255
        g = ((colorHexValue shr 8) and 0xFF).toDouble() / 255
        b = ((colorHexValue shr 0) and 0xFF).toDouble() / 255
    }
}