package br.com.progdeelite.kmmprogdeelite.resources

import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object FontSizingResources {
    private val small by lazy { FontSizing.Small() }
    private val medium by lazy { FontSizing.Medium() }
    private val large by lazy { FontSizing.Large() }

    internal fun getFontSizing(): FontSizing {
        return when (getWindowSize()) {
            WindowSize.Small -> small
            WindowSize.Medium -> medium
            WindowSize.Large -> large
        }
    }
}

abstract class FontSizing(
    val tiny: FontSizingResource,
    val small: FontSizingResource,
    val normal: FontSizingResource,
    val medium: FontSizingResource,
    val big: FontSizingResource,
    val large: FontSizingResource,
    val huge: FontSizingResource,
) {
    internal class Small : FontSizing(
        tiny = FontSizingResource(8, 14),
        small = FontSizingResource(13, 18),
        normal = FontSizingResource(15, 19),
        medium = FontSizingResource(17, 23),
        big = FontSizingResource(19, 24),
        large = FontSizingResource(24, 28),
        huge = FontSizingResource(27, 30),
    )

    internal class Medium : FontSizing(
        tiny = FontSizingResource(10, 16),
        small = FontSizingResource(13, 18),
        normal = FontSizingResource(15, 19),
        medium = FontSizingResource(17, 23),
        big = FontSizingResource(20, 25),
        large = FontSizingResource(26, 30),
        huge = FontSizingResource(30, 34),
    )

    internal class Large : FontSizing(
        tiny = FontSizingResource(12, 18),
        small = FontSizingResource(14, 19),
        normal = FontSizingResource(16, 20),
        medium = FontSizingResource(19, 25),
        big = FontSizingResource(22, 27),
        large = FontSizingResource(30, 34),
        huge = FontSizingResource(34, 38),
    )
}