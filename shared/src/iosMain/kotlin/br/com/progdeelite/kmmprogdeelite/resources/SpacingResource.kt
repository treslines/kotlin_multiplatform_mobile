package br.com.progdeelite.kmmprogdeelite.resources

// IMPORTANTE: DESCOMENTA QUANDO TIVER NO MAC DESENVOLVENDO

actual fun getWindowSize(): WindowSize {
//    if (UIScreen.mainScreen.scale < 3.0) return WindowSize.Small
//    val width = UIScreen.mainScreen.bounds.useContents { // FOI SUPER TRICKY ISSO AQUI!
//        this.size.width
//    }
//    return if(width < 400.0) WindowSize.Medium else WindowSize.Large
    return WindowSize.Medium
}

actual class SpacingResource actual constructor(private val unit: Int) {
//    private val scale = UIScreen.mainScreen.scale
//
//    val pt: Double by lazy { pt() }
//    private fun pt(): Double {
//        return unit.toDouble() * scale
//    }
}