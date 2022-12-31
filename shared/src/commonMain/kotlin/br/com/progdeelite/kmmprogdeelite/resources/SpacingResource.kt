package br.com.progdeelite.kmmprogdeelite.resources

// 1) ESPECIFICAR TAMANHOS DE TELAS
// 2) OBTER TAMANHO DA TELA E RECURSO DE TAMANHO (ANDROID/IOS)
// 3) IMPLEMENTAR EM ANDROID E IOS (IOS FOI BEM TRICKY)
// 4) CRIAR SPACING RESOURCES
// 5) USAR EM RESOURCES

/**
 * Indicates which port view (window size) the app is running on
 */
expect fun getWindowSize(): WindowSize

/**
 * Returns Dp for android and points for iOS
 */
expect class SpacingResource(unit: Int)

enum class WindowSize(val size: Int) {
    // Those break points are defined by your UI/UX team
    Small(320), Medium(375), Large(430)
}