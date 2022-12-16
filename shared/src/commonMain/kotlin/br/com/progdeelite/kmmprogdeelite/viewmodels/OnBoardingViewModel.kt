package br.com.progdeelite.kmmprogdeelite.viewmodels

import br.com.progdeelite.kmmprogdeelite.resources.ImageResource
import br.com.progdeelite.kmmprogdeelite.resources.Resources

// 1) Implementar iOS e Android
// 2) definir classe compartilhada de Resources
// 3) Criar viewModel
// 4) Exemplificar o preview

class OnBoardingViewModel(
    val images: OnBoardingImages // Pitfall Nr1. kmm para iOS não sabe lidar com default parameters (ainda)
) : BaseSharedViewModel() {

    constructor() : this(
        images = OnBoardingImages() // tivemos que mover as inicializações padrão para o construtor
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