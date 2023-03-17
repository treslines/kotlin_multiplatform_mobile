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