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
expect class ColorResource(light: Long, dark: Long)