package pl.burno.selectionlauncher

import android.content.ComponentName
import android.content.pm.PackageManager
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@ExperimentalCoroutinesApi
class ActionToggler(private val packageManager: PackageManager) {

    private val _state = MutableStateFlow(supportedActions.map { name ->
        val componentEnabledValue = packageManager.getComponentEnabledSetting(
            name.toComponentName()
        )
        name to (componentEnabledValue == PackageManager.COMPONENT_ENABLED_STATE_ENABLED)
    })
    val state: StateFlow<List<Pair<String, Boolean>>> = _state

    fun toggle(name: String, isEnabled: Boolean) {
        packageManager.setComponentEnabledSetting(
            name.toComponentName(),
            isEnabled.toComponentState(),
            PackageManager.DONT_KILL_APP
        )
        _state.value = _state.value.map { (actionName, actionIsEnabled) ->
            actionName to if (actionName == name) isEnabled else actionIsEnabled
        }
    }

    private fun String.toComponentName() =
        ComponentName(PACKAGE_NAME, "$PACKAGE_NAME.$this")

    private fun Boolean.toComponentState(): Int {
        return if (this) {
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED
        } else {
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED
        }
    }
}