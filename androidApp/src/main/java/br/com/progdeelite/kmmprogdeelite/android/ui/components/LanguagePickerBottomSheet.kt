package br.com.progdeelite.kmmprogdeelite.android.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.AndroidAppTheme
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.TextStyles
import br.com.progdeelite.kmmprogdeelite.android.utils.DependencyInjectionForPreview
import br.com.progdeelite.kmmprogdeelite.localization.Language
import br.com.progdeelite.kmmprogdeelite.resources.Resources
import br.com.progdeelite.kmmprogdeelite.viewmodels.LanguagePickerViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// 1) especificar/atualizar textos, cores, strings
// 2) usar os textos LanguagePickerTexts
// 3) Definir o LanguagePickerViewModel
// 4) Criar o LanguagePickerBottomSheet
// 5) Posicionar no HomeScreen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LanguagePickerBottomSheet(
    viewModel: LanguagePickerViewModel,
    sheetState: ModalBottomSheetState,
    parentContent: @Composable () -> Unit
) {
    val currentAppLanguage by viewModel.language.collectAsState()

    val coroutineScope = rememberCoroutineScope()
    fun onUpdateAppLanguage(language: Language) {
        viewModel.trackLanguageAction()
        viewModel.setLanguage(language)
        coroutineScope.launch {
            delay(500L)
            sheetState.hide()
        }
    }

    val onRadioOptionSelectedAction = ::onUpdateAppLanguage

    ModalBottomSheet(
        title = viewModel.translations.title.localized,
        sheetState = sheetState,
        offset = Resources.Spacing.normal.dp,
        parentContent = { parentContent() }
    ) {
        LanguageBottomSheetContent(
            currentAppLanguage,
            radioLanguageOptions = viewModel.translations.languageOptions,
            onRadioOptionSelectedAction = onRadioOptionSelectedAction
        )
    }
}

@Composable
fun LanguageBottomSheetContent(
    currentAppLanguage: Language,
    radioLanguageOptions: List<Language>,
    onRadioOptionSelectedAction: (selectedLanguage: Language) -> Unit = {}
) {
    LanguageRadioButtonGroup(currentAppLanguage, radioLanguageOptions, onRadioOptionSelectedAction)
}

@Composable
fun LanguageRadioButtonGroup(
    currentAppLanguage: Language,
    radioLanguageOptions: List<Language>,
    onRadioOptionSelectedAction: (selectedLanguage: Language) -> Unit = {}
) {
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(currentAppLanguage) }
    val isSelectedItem: (String) -> Boolean = { selectedOption.text == it }
    Column(
        modifier = Modifier
    ) {
        radioLanguageOptions.forEach { language ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (language == selectedOption),
                        onClick = {
                            onOptionSelected(language)
                            onRadioOptionSelectedAction(language)
                        }
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Resources.Theme.langRadioColorSelected.getColor(),
                        unselectedColor = Resources.Theme.langRadioColorUnselected.getColor(),
                        disabledColor = Resources.Theme.langRadioColorDisabled.getColor()
                    ),
                    selected = (language == selectedOption),
                    onClick = {
                        onOptionSelected(language)
                        onRadioOptionSelectedAction(language)
                    }
                )
                AccessibilityText(
                    modifier = Modifier.padding(start = Resources.Spacing.medium.dp),
                    text = language.text,
                    style = TextStyles.body2,
                    color = getSelectionColors(isSelectedItem(language.text)),
                    maxLines = 1
                )
            }
        }
    }
}

private fun getSelectionColors(isTextSelected: Boolean): Color {
    return when (isTextSelected) {
        true -> Resources.Theme.langTextColorSelected.getColor()
        else -> Resources.Theme.langTextColorUnselected.getColor()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun LanguagePickerBottomSheetPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Expanded)

        LanguagePickerBottomSheet(
            viewModel = LanguagePickerViewModel(),
            sheetState = sheetState,
            parentContent = {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = "Open Sheet")
                }
            }
        )
    }
}