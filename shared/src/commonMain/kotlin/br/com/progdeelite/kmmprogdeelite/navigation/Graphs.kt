package br.com.progdeelite.kmmprogdeelite.navigation

// 1) COMO HABILITAR DEEPLINKS EM UM APP ANDROID (MANIFEST)
// 2) COMO MODELAR DEEPLINKS
// 3) COMO MONTAR UM ROTAS E DEEPLINKS COM UM BUILDER
// 4) COMO CRIAR A ROTAS APTAS A RECEBER E USAR DEEPLINKS

object Deeplink {
    const val scheme = "yourscheme"
    const val host = "yourcompany.com"

    const val baseUrl = "$scheme://$host/"
}

interface AppRoute {
    val startRoute: String
    val args get() = emptyList<String>()
    val params get() = emptyList<String>()

    // retorna a rota padrao definida no navigation graph
    val route get() = build(false)
    // retorna a rota padrao como parametro na url base do
    // deeplink especificado no manifest do app
    val deeplink get() = build(true)

    private fun build(asDeeplink: Boolean): String {
        return Builder(startRoute, asDeeplink)
            .setArgs(args)
            .setParams(params)
            .build()
    }

    // responsaval em montar as rotas ou deeplinks no formato esperado pelo framework
    private class Builder(private val destination: String, private val asDeeplink: Boolean = false) {
        var args: MutableList<String> = mutableListOf()
        var params: MutableList<String> = mutableListOf()

        fun setArgs(args: List<String>) = apply { this.args = args.toMutableList() }
        fun setParams(params: List<String>) = apply { this.params = params.toMutableList() }

        fun build(): String {
            val stringBuilder = StringBuilder()
            // se for deeplink, monta url do deeplink
            if (asDeeplink) {
                stringBuilder.append(Deeplink.baseUrl)
            }
            // do contrario apenas retorna a rota destino especificada no navigation graph
            stringBuilder.append(destination)

            // se na definiçao da rota foram especificados parametros ou argumentos,
            // adicione os mesmos a rota para que possam ser recuperados no destino
            // o formato de parametros ou argumentos segue a mesma convençao de uma
            // request http no format de get. Veja exemplo abaixo:
            // yourscheme://yourhost/param1/param2?arg1=val1&arg2=val2
            params.forEach { stringBuilder.append("/{$it}") }
            args.forEachIndexed { index, value ->
                when(index){
                    0 -> stringBuilder.append("?$value={$value}")
                    else -> stringBuilder.append("&$value={$value}")
                }
            }
            // retorne a rota completa
            return stringBuilder.toString()
        }
    }
}

object Graphs {

    object AppEntryGraph {
        const val root = "entry_graph"

        const val splash = "splash"
        const val onboarding = "onboarding"
    }

    object AuthRegisterGraph {
        const val root = "auth_register_graph"

        object Register : AppRoute {
            override val startRoute = "register"
            override val args = Args.from(NavArgs.values())

            enum class NavArgs{
                start_screen
            }
        }

        object Otp : AppRoute {
            override val startRoute = "register_otp"
            override val args = Args.from(NavArgs.values())

            enum class NavArgs{
                mobile
            }
        }
    }

    object AuthLoginGraph {
        const val root = "auth_login_graph"

        object Login : AppRoute {
            override val startRoute = "login"
            override val args = Args.from(NavArgs.values())
            enum class NavArgs {
                start_screen
            }
        }

        object Otp : AppRoute {
            override val startRoute = "login_otp"
            override val args = Args.from(NavArgs.values())

            enum class NavArgs{
                mobile
            }
        }
    }

    object InsuranceGraph {
        const val root = "insurance_graph"

        object Insurance : AppRoute {
            override val startRoute = "insurance"
        }
    }

    object SupportGraph {
        const val root = "support_graph"

        object Support : AppRoute {
            override val startRoute = "support"
        }
    }

    object HomeGraph {
        const val root = "home_graph"

        object Home : AppRoute {
            override val startRoute = "home"
        }

        object Profile : AppRoute {
            override val startRoute = "profile"
        }
    }
}

interface Args {
    companion object {
        fun <T: Enum<*>> from(type: T): String{
            return type.name
        }
        fun <T: Enum<*>> from(type: Array<T>): List<String>{
            return type.map {it.name}.toList()
        }
    }
}