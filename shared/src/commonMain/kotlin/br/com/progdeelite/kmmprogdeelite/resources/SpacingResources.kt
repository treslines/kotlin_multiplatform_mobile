package br.com.progdeelite.kmmprogdeelite.resources

import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object SpacingResources {
    private val small by lazy { Small() }
    private val medium by lazy { Medium() }
    private val large by lazy { Large() }

    internal fun getSpacing(): Spacing {
        return when (getWindowSize()) {
            WindowSize.Small -> small
            WindowSize.Medium -> medium
            WindowSize.Large -> large
        }
    }
}

abstract class Spacing(
    val noSpace: SpacingResource,
    val extraTiny: SpacingResource,
    val tiny: SpacingResource,
    val extraSmall: SpacingResource,
    val small: SpacingResource,
    val normal: SpacingResource,
    val medium: SpacingResource,
    val big: SpacingResource,
    val extraBig: SpacingResource,
    val large: SpacingResource,
    val extraLarge: SpacingResource,
    val huge: SpacingResource,
    val extraHuge: SpacingResource,
)

private class Small : Spacing(
    noSpace = SpacingResource(0),
    extraTiny = SpacingResource(2),
    tiny = SpacingResource(4),
    extraSmall = SpacingResource(8),
    small = SpacingResource(10),
    normal = SpacingResource(12),
    medium = SpacingResource(16),
    big = SpacingResource(20),
    extraBig = SpacingResource(22),
    large = SpacingResource(24),
    extraLarge = SpacingResource(36),
    huge = SpacingResource(40),
    extraHuge = SpacingResource(48),
)

private class Medium : Spacing(
    noSpace = SpacingResource(0),
    extraTiny = SpacingResource(2),
    tiny = SpacingResource(4),
    extraSmall = SpacingResource(8),
    small = SpacingResource(10),
    normal = SpacingResource(12),
    medium = SpacingResource(16),
    big = SpacingResource(24),
    extraBig = SpacingResource(28),
    large = SpacingResource(32),
    extraLarge = SpacingResource(40),
    huge = SpacingResource(48),
    extraHuge = SpacingResource(72),
)

private class Large : Spacing(
    noSpace = SpacingResource(0),
    extraTiny = SpacingResource(4),
    tiny = SpacingResource(6),
    extraSmall = SpacingResource(12),
    small = SpacingResource(16),
    normal = SpacingResource(20),
    medium = SpacingResource(24),
    big = SpacingResource(28),
    extraBig = SpacingResource(34),
    large = SpacingResource(36),
    extraLarge = SpacingResource(48),
    huge = SpacingResource(56),
    extraHuge = SpacingResource(96),
)