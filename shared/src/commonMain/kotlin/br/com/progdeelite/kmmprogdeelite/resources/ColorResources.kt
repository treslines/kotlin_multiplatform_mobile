package br.com.progdeelite.kmmprogdeelite.resources

import kotlin.native.concurrent.ThreadLocal

// VIDEO THEME E CORES COMPARTILHADAS (ASSISTA, VC VAI PRECISAR 100%):
// 1) https://youtu.be/NtI-MWFGUBE
// 2) https://youtu.be/kzbKuNtegkc
@ThreadLocal
object ColorResources {
    internal fun getTheme(): Theme = if (isSystemInDarkMode()) Theme.Dark else Theme.Light
    internal fun getDarkTheme(): Theme = Theme.Dark
    internal fun getLightTheme(): Theme = Theme.Light
}

abstract class Theme(
    // material theme android colors
    val primary: ColorResource,
    val primaryVariant: ColorResource,
    val secondary: ColorResource,
    val secondaryVariant: ColorResource,
    val background: ColorResource,
    val surface: ColorResource,
    val error: ColorResource,
    val onPrimary: ColorResource,
    val onSecondary: ColorResource,
    val onBackground: ColorResource,
    val onSurface: ColorResource,
    val onError: ColorResource,

    // default theming colors for background and content
    val contentPrimary: ColorResource,
    val contentSecondary: ColorResource,
    val backgroundPrimary: ColorResource,
    val backgroundSecondary: ColorResource,
    val backgroundSecondaryAlpha: ColorResource,
    val divider: ColorResource,
    val textPrimary: ColorResource,
    val textTertiary: ColorResource,
    val textSecondary: ColorResource,
    val iconPrimary: ColorResource,
    val iconSecondary: ColorResource,

    // default theming colors for buttons
    val strokeSecondary: ColorResource,
    val contentCloseButton: ColorResource,
    val backgroundCloseButton: ColorResource,
    val disabledBackgroundCloseButton: ColorResource,

    // further content and background with index
    val content1: ColorResource,
    val background1: ColorResource,

    // default text theming colors
    val title: ColorResource,
    val titleSecondary: ColorResource,
    val subtitle: ColorResource,
    val description: ColorResource,

    val iconConnectivityOnline: ColorResource,
    val iconConnectivityOffline: ColorResource,
    val textConnectivityOnline: ColorResource,
    val textConnectivityOffline: ColorResource,
    val bgConnectivityOnline: ColorResource,
    val bgConnectivityOffline: ColorResource,

    // textos
    val textFieldHintColor: ColorResource,
    val textFieldCursorColor: ColorResource,
    val textFieldSelectedFocusColor: ColorResource,
    val textFieldUnselectedFocusColor: ColorResource,

    // buttons
    val loadingButtonActiveColor: ColorResource,
    val loadingButtonLoadingColor: ColorResource,
    val loadingButtonDisabledColor: ColorResource,

    val scrimColor: ColorResource,

    val selectedContentColor: ColorResource,
    val unselectedContentColor: ColorResource,

    val bgOverlayHeaderDefault: ColorResource,
    val bgOverlayHeaderScroll: ColorResource,
    val textStartColor: ColorResource,
    val textEndColor: ColorResource,
    val btnBgWhiteAlpha: ColorResource,
    val btnBgGrayAlpha: ColorResource,
    val defaultTextColor: ColorResource,

) {
    object Dark : Theme(
        primary = ColorResource(0xFF9CECFB), // azul claro
        primaryVariant = ColorResource(0xFF9CECFB), // azul claro
        secondary = ColorResource(0xFF707070), // black 60% alpha
        secondaryVariant = ColorResource(0xFF707070), // black 60% alpha
        background = ColorResource(0xFFEFEFEF), // black 5% alpha
        surface = ColorResource(0xFF707070), // white
        error = ColorResource(0xFF65C7F7), // azul 60% mais claro
        onPrimary = ColorResource(0xFFFFFFFF), // white
        onSecondary = ColorResource(0xFFFFFFFF), // white
        onBackground = ColorResource(0xFF131313), // black
        onSurface = ColorResource(0xFF131313), // black
        onError = ColorResource(0xFFFFFFFF), // white

        iconConnectivityOnline = ColorResource(0xFF00D80A),
        iconConnectivityOffline = ColorResource(0xFFFFFFFF),
        textConnectivityOnline = ColorResource(0xFF131313),
        textConnectivityOffline = ColorResource(0xFFFFFFFF),
        bgConnectivityOnline = ColorResource(0xFF76DA96),
        bgConnectivityOffline = ColorResource(0xFFDC4657),

        textFieldHintColor = ColorResource(0xFF707070),
        textFieldCursorColor = ColorResource(0xFF131313),
        textFieldSelectedFocusColor = ColorResource(0xFFEFEFEF),
        textFieldUnselectedFocusColor = ColorResource(0xFF707070),

        loadingButtonActiveColor = ColorResource(0xFFE95D0F),
        loadingButtonLoadingColor = ColorResource(0xFFF09C6D),
        loadingButtonDisabledColor = ColorResource(0xFFEFEFEF),

        contentPrimary = ColorResource(0xFFFFFFFF), // white
        contentSecondary = ColorResource(0xFF131313), // black
        backgroundPrimary = ColorResource(0xFF414141), // azul
        backgroundSecondary = ColorResource(0xFF707070), // black 60% alpha
        backgroundSecondaryAlpha = ColorResource(0x66FFFFFF), // white 40% alpha
        strokeSecondary = ColorResource(0xFF131313), // black
        divider = ColorResource(0xFFFFFFFF), // white
        textPrimary = ColorResource(0xFFFFFFFF), // white
        textSecondary = ColorResource(0xFF131313), // black
        textTertiary = ColorResource(0xFF131313), // black
        iconPrimary = ColorResource(0xFF131313), // black
        iconSecondary = ColorResource(0x99131313), // back 60% alpha
        content1 = ColorResource(0xFFFFFFFF), // white
        background1 = ColorResource(0xFF9CECFB), // azul claro
        title = ColorResource(0xFF131313), // black
        titleSecondary = ColorResource(0xFFFFFFFF), // white
        subtitle = ColorResource(0xFF131313), // black
        description = ColorResource(0xFF9CECFB), // azul claro
        contentCloseButton = ColorResource(0xFFFFFFFF), // white
        backgroundCloseButton = ColorResource(0xFF9CECFB), // azul claro
        disabledBackgroundCloseButton = ColorResource(0x99131313), // back 60% alpha
        scrimColor = ColorResource(0xFF707070),

        selectedContentColor = ColorResource(0xFF1894E1), // azul
        unselectedContentColor = ColorResource(0x99131313), // back 60% alpha

        bgOverlayHeaderDefault = ColorResource(0x00FFFFFF), // white 0% alpha
        bgOverlayHeaderScroll = ColorResource(0xFFC0D6DF), // grey light
        textStartColor = ColorResource(0xFFFFFFFF), // back 60% alpha
        textEndColor = ColorResource(0x99131313), // back 60% alpha
        btnBgWhiteAlpha = ColorResource(0xFFFFFFFF), // white
        btnBgGrayAlpha = ColorResource(0xFFEFEFEF), // black 5% alpha
        defaultTextColor = ColorResource(0x99131313), // back 60% alpha
    )

    object Light : Theme(

        primary = ColorResource(0xFF9CECFB), // azul claro
        primaryVariant = ColorResource(0xFF9CECFB), // azul claro
        secondary = ColorResource(0xFF707070), // black 60% alpha
        secondaryVariant = ColorResource(0xFF707070), // black 60% alpha
        background = ColorResource(0xFFEFEFEF), // black 5% alpha
        surface = ColorResource(0xFFFFFFFF), // white
        error = ColorResource(0xFF65C7F7), // azul 60% mais claro
        onPrimary = ColorResource(0xFFFFFFFF), // white
        onSecondary = ColorResource(0xFFFFFFFF), // white
        onBackground = ColorResource(0xFF131313), // black
        onSurface = ColorResource(0xFF131313), // black
        onError = ColorResource(0xFFFFFFFF), // white

        iconConnectivityOnline = ColorResource(0xFF00D80A),
        iconConnectivityOffline = ColorResource(0xFFFFFFFF),
        textConnectivityOnline = ColorResource(0xFF131313),
        textConnectivityOffline = ColorResource(0xFFFFFFFF),
        bgConnectivityOnline = ColorResource(0xFF76DA96),
        bgConnectivityOffline = ColorResource(0xFFDC4657),

        textFieldHintColor = ColorResource(0xFF707070),
        textFieldCursorColor = ColorResource(0xFF131313),
        textFieldSelectedFocusColor = ColorResource(0xFFEFEFEF),
        textFieldUnselectedFocusColor = ColorResource(0xFF707070),

        loadingButtonActiveColor = ColorResource(0xFFE95D0F),
        loadingButtonLoadingColor = ColorResource(0xFFF09C6D),
        loadingButtonDisabledColor = ColorResource(0xFFEFEFEF),

        contentPrimary = ColorResource(0xFFFFFFFF), // white
        contentSecondary = ColorResource(0xFF9CECFB), // azul claro
        backgroundPrimary = ColorResource(0xFF1894E1), // azul
        backgroundSecondary = ColorResource(0xFFFFFFFF), // white
        strokeSecondary = ColorResource(0xFF9CECFB), // azul claro
        backgroundSecondaryAlpha = ColorResource(0x66FFFFFF), // white 40% alpha
        divider = ColorResource(0xFFEFEFEF), // black 5% alpha
        textPrimary = ColorResource(0xFF131313), // black
        textTertiary = ColorResource(0xFF707070), // black 60% alpha
        textSecondary = ColorResource(0xFF9CECFB), // azul claro
        iconPrimary = ColorResource(0xFF9CECFB), // azul claro
        iconSecondary = ColorResource(0xFF65C7F7), // azul 60% mais claro
        content1 = ColorResource(0xFF9CECFB), // azul claro
        background1 = ColorResource(0xFFFFFFFF), // white
        title = ColorResource(0xFFFFFFFF), // white
        titleSecondary = ColorResource(0xFF131313), // black
        subtitle = ColorResource(0xFFFFFFFF), // white
        description = ColorResource(0xFF131313), // black
        contentCloseButton = ColorResource(0xFF414141), // black 80% alpha
        backgroundCloseButton = ColorResource(0xFFEFEFEF), // black 5% alpha
        disabledBackgroundCloseButton = ColorResource(0x99131313), // back 60% alpha
        scrimColor = ColorResource(0xFF707070),

        selectedContentColor = ColorResource(0xFF1894E1), // azul
        unselectedContentColor = ColorResource(0x99131313), // back 60% alpha

        bgOverlayHeaderDefault = ColorResource(0x00FFFFFF), // white 0% alpha
        bgOverlayHeaderScroll = ColorResource(0xFFC0D6DF), // grey light
        textStartColor = ColorResource(0xFFFFFFFF), // back 60% alpha
        textEndColor = ColorResource(0x99131313), // back 60% alpha
        btnBgWhiteAlpha = ColorResource(0xFFFFFFFF), // white
        btnBgGrayAlpha = ColorResource(0xFFEFEFEF), // black 5% alpha
        defaultTextColor = ColorResource(0x99131313), // back 60% alpha
    )
}

