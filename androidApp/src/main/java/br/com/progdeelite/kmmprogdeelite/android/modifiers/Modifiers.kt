package br.com.progdeelite.kmmprogdeelite.android.modifiers

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.debugInspectorInfo

fun Modifier.onFocusChangedIgnoreInitialState(onFocusChanged: (FocusState) -> Unit): Modifier =
    composed(
        inspectorInfo = debugInspectorInfo {
            name = "onFocusChangedIgnoreInitialState"
            properties["onFocusChanged"] = onFocusChanged
        }
    ) {
       val focusState: MutableState<FocusState?> = remember { mutableStateOf(null) }
        Modifier.onFocusChanged {
            if(focusState.value != it) {
                if(focusState.value != null){
                    onFocusChanged(it)
                }
                focusState.value = it
            }
        }
    }