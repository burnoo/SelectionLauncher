package pl.burno.selectionlauncher

import android.content.ComponentName
import android.content.pm.PackageManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.suspendCancellableCoroutine
import pl.burno.selectionlauncher.domain.Action
import pl.burno.selectionlauncher.domain.EnabledAction
import kotlin.coroutines.resume

private const val PACKAGE_NAME = "pl.burno.selectionlauncher"

class ActionToggler(private val packageManager: PackageManager) {

    private val _state = MutableStateFlow<List<EnabledAction>?>(null)
    val state: Flow<List<EnabledAction>> = _state.filterNotNull()

    suspend fun initialize() {
        _state.value = getInitialState()
    }

    private suspend fun getInitialState(): List<EnabledAction> = suspendCancellableCoroutine {
        val enabledActions = Action.values().map { action ->
            val componentEnabledValue = packageManager
                .getComponentEnabledSetting(action.toComponentName())
            action.toEnabledAction(
                isEnabled = componentEnabledValue != PackageManager.COMPONENT_ENABLED_STATE_DISABLED
            )
        }
        it.resume(enabledActions)
    }

    fun toggle(action: Action, isEnabled: Boolean) {
        val currentState = _state.value
            ?: throw IllegalStateException("Toggle without initialization")
        packageManager.setComponentEnabledSetting(
            action.toComponentName(),
            isEnabled.toComponentState(),
            PackageManager.DONT_KILL_APP
        )
        _state.value = currentState.map { enabledAction ->
            if (enabledAction.action == action) action.toEnabledAction(isEnabled) else enabledAction
        }
    }


    private fun Action.toComponentName() =
        ComponentName(PACKAGE_NAME, "$PACKAGE_NAME.$actionName")

    private fun Boolean.toComponentState(): Int {
        return if (this) {
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED
        } else {
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED
        }
    }
}