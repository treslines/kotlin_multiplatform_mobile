package br.com.progdeelite.kmmprogdeelite.resources

/** Shared resources for android and iOS */
object Resources {
    val Image = ImageResources
    val Strings = StringResources
    val Color = ColorResources

    // IMPORTANTE ENTENDER: como isso aqui é um objeto singleton (equivalente a um objeto estático em java)
    // ele so seria instanciado uma única vez. Como o thema pode mudar dinámicamente, é importante
    // sempre fazer uma "chamada" para o Color.getTheme() para garantir o theming correto!
    // Uso: Iremos acessar e atribuir da seguinte maneira nas views: Resources.Theme.primaryColor.getColor()
    val Theme: Theme
        get() = Color.getTheme()
}