package br.com.progdeelite.kmmprogdeelite.resources

import kotlin.native.concurrent.ThreadLocal

// VIDEO THEME E CORES COMPARTILHADAS (ASSISTA, VC VAI PRECISAR 100%):
// 1) https://youtu.be/NtI-MWFGUBE
// 2) https://youtu.be/kzbKuNtegkc
@ThreadLocal
object ColorResources {
    internal fun getTheme() = Themes
}

object Themes {
    val transparent by lazy { ColorResource(light = ColorScheme.transparent, dark = ColorScheme.transparent) }

    val primary by lazy { ColorResource(light = ColorScheme.blueLight, dark = ColorScheme.blueLight) }
    val primaryVariant by lazy { ColorResource(light = ColorScheme.blueLight, dark = ColorScheme.blueLight) }
    val secondary by lazy { ColorResource(light = ColorScheme.gray60a, dark = ColorScheme.gray60a) }
    val secondaryVariant by lazy { ColorResource(light = ColorScheme.gray60a, dark = ColorScheme.gray60a) }

    val background by lazy { ColorResource(light = ColorScheme.black5a, dark = ColorScheme.black5a) }
    val surface by lazy { ColorResource(light = ColorScheme.white, dark = ColorScheme.gray60a) }
    val error by lazy { ColorResource(light = ColorScheme.blue60a, dark = ColorScheme.blue60a) }
    val onPrimary by lazy { ColorResource(light = ColorScheme.white, dark = ColorScheme.white) }
    val onSecondary by lazy { ColorResource(light = ColorScheme.white, dark = ColorScheme.white) }
    val onBackground by lazy { ColorResource(light = ColorScheme.black, dark = ColorScheme.black) }
    val onSurface by lazy { ColorResource(light = ColorScheme.black, dark = ColorScheme.black) }
    val onError by lazy { ColorResource(light = ColorScheme.white, dark = ColorScheme.white) }

    val iconConnectivityOnline by lazy { ColorResource(light = ColorScheme.greenDark, dark = ColorScheme.greenDark) }
    val bgConnectivityOnline by lazy { ColorResource(light = ColorScheme.greenLight, dark = ColorScheme.greenLight) }
    val iconConnectivityOffline by lazy { ColorResource(light = ColorScheme.white, dark = ColorScheme.white0a) }
    val textConnectivityOnline by lazy { ColorResource(light = ColorScheme.black, dark = ColorScheme.black) }
    val textConnectivityOffline by lazy { ColorResource(light = ColorScheme.white, dark = ColorScheme.white) }
    val bgConnectivityOffline by lazy { ColorResource(light = ColorScheme.redDark, dark = ColorScheme.redDark) }
    val textFieldHintColor by lazy { ColorResource(light = ColorScheme.gray60a, dark = ColorScheme.gray60a) }
    val textFieldCursorColor by lazy { ColorResource(light = ColorScheme.black, dark = ColorScheme.black) }
    val textFieldSelectedFocusColor by lazy { ColorResource(light = ColorScheme.black5a, dark = ColorScheme.black5a) }
    val textFieldUnselectedFocusColor by lazy { ColorResource(light = ColorScheme.gray60a, dark = ColorScheme.gray60a) }
    val loadingButtonActiveColor by lazy { ColorResource(light = ColorScheme.orangeDark, dark = ColorScheme.orangeDark) }
    val loadingButtonLoadingColor by lazy { ColorResource(light = ColorScheme.orangeLight, dark = ColorScheme.orangeLight) }
    val loadingButtonDisabledColor by lazy { ColorResource(light = ColorScheme.black5a, dark = ColorScheme.black5a) }

    val contentPrimary by lazy { ColorResource(light = ColorScheme.white, dark = ColorScheme.white) }
    val contentSecondary by lazy { ColorResource(light = ColorScheme.blueLight, dark = ColorScheme.black) }
    val backgroundPrimary by lazy { ColorResource(light = ColorScheme.blueSky, dark = ColorScheme.blue) }
    val backgroundSecondary by lazy { ColorResource(light = ColorScheme.white, dark = ColorScheme.gray60a) }
    val backgroundSecondaryAlpha by lazy { ColorResource(light = ColorScheme.white40a, dark = ColorScheme.white40a) }
    val strokeSecondary by lazy { ColorResource(light = ColorScheme.blueLight, dark = ColorScheme.black) }
    val divider by lazy { ColorResource(light = ColorScheme.black5a, dark = ColorScheme.white) }
    val textPrimary by lazy { ColorResource(light = ColorScheme.black, dark = ColorScheme.white) }
    val textSecondary by lazy { ColorResource(light = ColorScheme.blueLight, dark = ColorScheme.black) }
    val textTertiary by lazy { ColorResource(light = ColorScheme.gray60a, dark = ColorScheme.black) }
    val iconPrimary by lazy { ColorResource(light = ColorScheme.blueLight, dark = ColorScheme.black) }
    val iconSecondary by lazy { ColorResource(light = ColorScheme.blue60a, dark = ColorScheme.black60a) }
    val content1 by lazy { ColorResource(light = ColorScheme.blueLight, dark = ColorScheme.white) }
    val background1 by lazy { ColorResource(light = ColorScheme.white, dark = ColorScheme.blueLight) }
    val title by lazy { ColorResource(light = ColorScheme.white, dark = ColorScheme.black) }
    val titleSecondary by lazy { ColorResource(light = ColorScheme.black, dark = ColorScheme.white) }
    val subtitle by lazy { ColorResource(light = ColorScheme.white, dark = ColorScheme.black) }
    val description by lazy { ColorResource(light = ColorScheme.black, dark = ColorScheme.blueLight) }
    val contentCloseButton by lazy { ColorResource(light = ColorScheme.blue, dark = ColorScheme.white) }
    val backgroundCloseButton by lazy { ColorResource(light = ColorScheme.grayLaminate, dark = ColorScheme.blueLight) }
    val disabledBackgroundCloseButton by lazy { ColorResource(light = ColorScheme.black60a, dark = ColorScheme.black60a) }
    val scrimColor by lazy { ColorResource(light = ColorScheme.transparent, dark = ColorScheme.gray60a) }

    val selectedContentColor by lazy { ColorResource(light = ColorScheme.blueSky, dark = ColorScheme.blueSky) }
    val unselectedContentColor by lazy { ColorResource(light = ColorScheme.black60a, dark = ColorScheme.black60a) }

    val bgOverlayHeaderDefault by lazy { ColorResource(light = ColorScheme.white0a, dark = ColorScheme.white0a) }
    val bgOverlayHeaderScroll by lazy { ColorResource(light = ColorScheme.blueCloudy, dark = ColorScheme.blueCloudy) }
    val textStartColor by lazy { ColorResource(light = ColorScheme.white, dark = ColorScheme.white) }
    val textEndColor by lazy { ColorResource(light = ColorScheme.black60a, dark = ColorScheme.black60a) }
    val btnBgWhiteAlpha by lazy { ColorResource(light = ColorScheme.white, dark = ColorScheme.white) }
    val btnBgGrayAlpha by lazy { ColorResource(light = ColorScheme.black5a, dark = ColorScheme.black5a) }
    val defaultTextColor by lazy { ColorResource(light = ColorScheme.black60a, dark = ColorScheme.black60a) }

    val langTextColorSelected by lazy { ColorResource(light = ColorScheme.black, dark = ColorScheme.orangeDark) }
    val langTextColorUnselected by lazy { ColorResource(light = ColorScheme.black60a, dark = ColorScheme.black) }
    val langRadioColorSelected by lazy { ColorResource(light = ColorScheme.blueLight, dark = ColorScheme.orangeDark) }
    val langRadioColorUnselected by lazy { ColorResource(light = ColorScheme.black60a, dark = ColorScheme.orangeLight) }
    val langRadioColorDisabled by lazy { ColorResource(light = ColorScheme.black60a, dark = ColorScheme.orangeLight) }

    val labelDisabled by lazy { ColorResource(light = ColorScheme.black5a, dark = ColorScheme.black5a) }
    val labelDefault by lazy { ColorResource(light = ColorScheme.black60a, dark = ColorScheme.black60a) }
    val labelInteractive by lazy { ColorResource(light = ColorScheme.gold, dark = ColorScheme.blueLight) }

    val textPlaceholder by lazy { ColorResource(light = ColorScheme.greenLight, dark = ColorScheme.blueLight) }
    val textDefault by lazy { ColorResource(light = ColorScheme.black, dark = ColorScheme.white) }
    val textDisabled by lazy { ColorResource(light = ColorScheme.gray60a, dark = ColorScheme.gray60a) }
    val textMuted by lazy { ColorResource(light = ColorScheme.gray60a, dark = ColorScheme.grayLaminate) }
    val badgeActiveText by lazy { ColorResource(light = ColorScheme.greenExtraDark, dark = ColorScheme.greenExtraDark) }
    val badgeActiveBg by lazy { ColorResource(light = ColorScheme.greenLight, dark = ColorScheme.greenLight) }
}

