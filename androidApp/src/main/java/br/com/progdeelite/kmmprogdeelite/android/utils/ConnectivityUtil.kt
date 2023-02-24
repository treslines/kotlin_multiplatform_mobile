package br.com.progdeelite.kmmprogdeelite.android.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import androidx.compose.ui.platform.LocalContext
import br.com.progdeelite.kmmprogdeelite.utils.ConnectivityState
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

/** Network utility to get current state of internet connection */
val Context.currentConnectivityState: ConnectivityState
    get() {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return getCurrentConnectivityState(connectivityManager)
    }

@Suppress("DEPRECATION")
private fun getCurrentConnectivityState(connectivityManager: ConnectivityManager): ConnectivityState {
    val connected = connectivityManager.allNetworks.any { network ->
        connectivityManager.getNetworkCapabilities(network)?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) ?: false
    }
    return if (connected) ConnectivityState.Online else ConnectivityState.Offline
}

/**
 * launches coroutine scoped to the Composition which holds the State.
 * It’ll be automatically get cancelled once it leaves the composition
 */
@Composable
fun connectivityState(): State<ConnectivityState> {
    val context = LocalContext.current

    return produceState(initialValue = context.currentConnectivityState) {
        context.observeConnectivityAsFlow().collect { value = it }
    }
}

/** Network Utility to observe availability or unavailability of Internet connection */
fun Context.observeConnectivityAsFlow() = callbackFlow {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val callback = networkCallback { connectionState -> trySend(connectionState) }
    val networkRequest = NetworkRequest.Builder().addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET).build()
    connectivityManager.registerNetworkCallback(networkRequest, callback)

    // Set current state
    trySend(getCurrentConnectivityState(connectivityManager))

    // Remove callback when not used
    awaitClose {
        connectivityManager.unregisterNetworkCallback(callback)
    }
}

private fun networkCallback(callback: (ConnectivityState) -> Unit): ConnectivityManager.NetworkCallback {
    return object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            callback(ConnectivityState.Online)
        }

        override fun onLost(network: Network) {
            callback(ConnectivityState.Offline)
        }
    }
}