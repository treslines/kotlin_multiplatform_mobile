package br.com.progdeelite.kmmprogdeelite.viewmodels

import br.com.progdeelite.kmmprogdeelite.di.DI.inject
import br.com.progdeelite.kmmprogdeelite.network.Environment
import br.com.progdeelite.kmmprogdeelite.resources.ImageResource
import br.com.progdeelite.kmmprogdeelite.resources.Resources
import br.com.progdeelite.kmmprogdeelite.resources.TextResource
import br.com.progdeelite.kmmprogdeelite.utils.CommonLoggerImpl

// 1) Implementar iOS e Android
// 2) definir classe compartilhada de Resources
// 3) Criar viewModel
// 4) Exemplificar o preview

class OnBoardingViewModel(
    val images: OnBoardingImages, // Pitfall Nr1. kmm para iOS não sabe lidar com default parameters (ainda)
    val texts: OnBoardingTexts
) : BaseSharedViewModel() {

    private val environment by inject<Environment>()

    init{
        CommonLoggerImpl().log("Meu ambiente corrente é: ${environment.name}")
    }

    constructor() : this(
        images = OnBoardingImages(), // iOS: tivemos que mover as inicializações padrão para o construtor
        texts = OnBoardingTexts()
    )
}

// Para fins didáticos aqui, mas poderia estar em um arquivo separado
data class OnBoardingImages(
    val topImage: ImageResource,
    val middleImage: ImageResource,
    val bottomImage: ImageResource
) {
    constructor() : this(
        topImage = Resources.Image.fire,
        middleImage = Resources.Image.lamp,
        bottomImage = Resources.Image.switch
    )
}

// Para fins didáticos aqui, mas poderia estar em um arquivo separado
data class OnBoardingTexts(
    val topImageText: TextResource,
    val middleImageText: TextResource,
    val bottomImageText: TextResource
) {
    constructor() : this(
        topImageText = Resources.Strings.top_image_text,
        middleImageText = Resources.Strings.middle_image_text,
        bottomImageText = Resources.Strings.bottom_image_text
    )
}