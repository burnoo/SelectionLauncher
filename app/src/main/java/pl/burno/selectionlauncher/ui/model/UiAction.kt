package pl.burno.selectionlauncher.ui.model

import pl.burno.selectionlauncher.R
import pl.burno.selectionlauncher.domain.Action
import pl.burno.selectionlauncher.domain.EnabledAction

val defaultUiActions = Action.values().map { action ->
    action.toEnabledAction(true).toUiAction()
}

data class UiAction(
    val name: String,
    val iconResId: Int,
    val isEnabled: Boolean,
)

fun EnabledAction.toUiAction() = when (action) {
    Action.Instagram -> UiAction(action.actionName, R.drawable.ic_instagram, isEnabled)
    Action.Snapchat -> UiAction(action.actionName, R.drawable.ic_snapchat, isEnabled)
}