package pl.burno.selectionlauncher

import android.content.ComponentName
import android.content.pm.PackageManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import pl.burno.selectionlauncher.domain.Action

private const val PACKAGE_NAME = "pl.burno.selectionlauncher"

class ActionToggler(private val packageManager: PackageManager) {

    private val _state = MutableStateFlow(Action.values().map { action ->
        val componentEnabledValue = packageManager
            .getComponentEnabledSetting(action.toComponentName())
        action to (componentEnabledValue != PackageManager.COMPONENT_ENABLED_STATE_DISABLED)
    })
    val state: StateFlow<List<Pair<Action, Boolean>>> = _state

    fun toggle(action: Action, isEnabled: Boolean) {
        packageManager.setComponentEnabledSetting(
            action.toComponentName(),
            isEnabled.toComponentState(),
            PackageManager.DONT_KILL_APP
        )
        _state.value = _state.value.map { (stateAction, stateIsEnabled) ->
            stateAction to if (stateAction == action) isEnabled else stateIsEnabled
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