package br.com.progdeelite.kmmprogdeelite.utils

import br.com.progdeelite.kmmprogdeelite.resources.TextResource

abstract class CallToAction {
    class Email(
        val address: TextResource,
        val subject: TextResource
    ): CallToAction()

    class Call(
        val number: TextResource
    ): CallToAction()
}

// 1) LICÕES APRENDIDAS - COMO COMPARTILHAR RECURSOS/
// 2) QUAIS CLASSES EVITAR (QUE O DEV KOTLIN VAI CAIR NA ARMADILHA)
// 3) NÃO USE DEFAULT ARGUMENTS EM CLASSES COMPARTILHADAS/WORKAROUND











// NÃO FACA ASSIM! USE CLASSE ABSTRATA - IOS NÃO SABE LIDAR (AINDA) COM SEALED CLASSES
sealed class CallToAction2 {
    class Email(
        val address: TextResource,
        val subject: TextResource
    ): CallToAction2()

    class Call(
        val number: TextResource
    ): CallToAction2()
}