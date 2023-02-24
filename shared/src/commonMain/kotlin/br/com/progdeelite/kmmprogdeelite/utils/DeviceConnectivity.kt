package br.com.progdeelite.kmmprogdeelite.utils

import br.com.progdeelite.kmmprogdeelite.resources.*

abstract class ConnectivityState {
    object Online : ConnectivityState()
    object Offline : ConnectivityState()
}

interface ConnectivityProperty {
    val icon: ImageResource
    val iconColor: ColorResource
    val text: TextResource
    val textColor: ColorResource
    val textSize: FontSizingResource
    val backgroundColor: ColorResource
    val slideOutDurationInSeconds: Int
}

class OfflineProperty : ConnectivityProperty {
    override val icon: ImageResource by lazy { Resources.Image.flash }
    override val iconColor: ColorResource by lazy { Resources.Theme.iconConnectivityOffline }
    override val text: TextResource by lazy { Resources.Strings.connectivity_ct_device_offline }
    override val textSize: FontSizingResource by lazy { Resources.FontSizing.small }
    override val textColor: ColorResource by lazy { Resources.Theme.textConnectivityOffline }
    override val backgroundColor: ColorResource by lazy { Resources.Theme.bgConnectivityOffline }
    override val slideOutDurationInSeconds: Int by lazy { 0 }
}

class OnlineProperty : ConnectivityProperty {
    override val icon: ImageResource by lazy { Resources.Image.wifi }
    override val iconColor: ColorResource by lazy { Resources.Theme.iconConnectivityOnline }
    override val text: TextResource by lazy { Resources.Strings.connectivity_ct_device_online }
    override val textSize: FontSizingResource by lazy { Resources.FontSizing.small }
    override val textColor: ColorResource by lazy { Resources.Theme.textConnectivityOnline }
    override val backgroundColor: ColorResource by lazy { Resources.Theme.bgConnectivityOnline }
    override val slideOutDurationInSeconds: Int by lazy { 2 }
}