package br.com.progdeelite.kmmprogdeelite.resources.components

import br.com.progdeelite.kmmprogdeelite.resources.ImageResource
import br.com.progdeelite.kmmprogdeelite.resources.Resources
import br.com.progdeelite.kmmprogdeelite.resources.TextResource

data class ResendSmsResources(
    val title: TextResource,
    val sendSmsText: TextResource,
    val resendSmsText: TextResource,
    val placeholder: TextResource,
    val errorIcon: ImageResource

) {
    constructor() : this(
        title = Resources.Strings.sms_text_title,
        sendSmsText = Resources.Strings.sms_text_send,
        resendSmsText = Resources.Strings.sms_text_resend,
        placeholder = Resources.Strings.sms_textfield_hint,
        errorIcon = Resources.Image.info
    )
}