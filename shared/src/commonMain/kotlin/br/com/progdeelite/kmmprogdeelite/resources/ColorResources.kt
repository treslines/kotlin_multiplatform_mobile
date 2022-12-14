package br.com.progdeelite.kmmprogdeelite.resources

import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object ColorResources {
    fun getTheme(): Theme = if (isSystemInDarkMode()) Theme.Dark else Theme.Light
}

abstract class Theme (
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
) {
    object Dark : Theme (
        contentPrimary =  ColorResource(0xFFFFFFFF), // white
        contentSecondary =  ColorResource(0xFF131313), // black
        backgroundPrimary = ColorResource(0xFF414141), // black 80% alpha
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
        background1 = ColorResource(0xFFE95D0F), // laranja
        title = ColorResource(0xFF131313), // black
        titleSecondary = ColorResource(0xFFFFFFFF), // white
        subtitle = ColorResource(0xFF131313), // black
        description = ColorResource(0xFFE95D0F), // laranja
        contentCloseButton = ColorResource(0xFFFFFFFF), // white
        backgroundCloseButton = ColorResource(0xFFE95D0F), // laranja
        disabledBackgroundCloseButton = ColorResource(0x99131313), // back 60% alpha
    )

    object Light : Theme (
        contentPrimary =  ColorResource(0xFFFFFFFF), // white
        contentSecondary =  ColorResource(0xFFE95D0F), // laranja
        backgroundPrimary = ColorResource(0xFFE95D0F), // laranja
        backgroundSecondary = ColorResource(0xFFFFFFFF), // white
        strokeSecondary = ColorResource(0xFFE95D0F), // laranja
        backgroundSecondaryAlpha = ColorResource(0x66FFFFFF), // white 40% alpha
        divider = ColorResource(0xFFEFEFEF), // black 5% alpha
        textPrimary = ColorResource(0xFF131313), // black
        textTertiary = ColorResource(0xFF707070), // black 60% alpha
        textSecondary = ColorResource(0xFFE95D0F), // laranja
        iconPrimary = ColorResource(0xFFE95D0F), // laranja
        iconSecondary = ColorResource(0xFFF09C6D), // laranja 60% alpha
        content1 = ColorResource(0xFFE95D0F), // laranja
        background1 = ColorResource(0xFFFFFFFF), // white
        title = ColorResource(0xFFFFFFFF), // white
        titleSecondary = ColorResource(0xFF131313), // black
        subtitle = ColorResource(0xFFFFFFFF), // white
        description = ColorResource(0xFF131313), // black
        contentCloseButton = ColorResource(0xFF414141), // black 80% alpha
        backgroundCloseButton = ColorResource(0xFFEFEFEF), // black 5% alpha
        disabledBackgroundCloseButton = ColorResource(0x99131313), // back 60% alpha
    )
}

