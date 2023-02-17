package br.com.progdeelite.kmmprogdeelite.localization

import br.com.progdeelite.kmmprogdeelite.resources.Resources
import br.com.progdeelite.kmmprogdeelite.resources.TextResource

abstract class DialogTexts (
    val title: TextResource,
    val description: TextResource,
    val primaryButtonText: TextResource,
    val secondaryButtonText: TextResource?,

){
    object ForceUpdate: DialogTexts (
        title = Resources.Strings.dialog_title_force_update,
        description = Resources.Strings.dialog_description_force_update,
        primaryButtonText = Resources.Strings.dialog_primary_button_text_force_update,
        secondaryButtonText = Resources.Strings.dialog_secondary_button_text_force_update
    )

    object Cancel: DialogTexts (
        title = Resources.Strings.dialog_title_cancel,
        description = Resources.Strings.dialog_description_cancel,
        primaryButtonText = Resources.Strings.dialog_primary_button_text_cancel,
        secondaryButtonText = Resources.Strings.dialog_secondary_button_cancel
    )
}