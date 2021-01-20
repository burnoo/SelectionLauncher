package pl.burno.selectionlauncher.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.map
import pl.burno.selectionlauncher.ActionToggler
import pl.burno.selectionlauncher.domain.Action
import pl.burno.selectionlauncher.domain.EnabledAction
import pl.burno.selectionlauncher.ui.model.UiAction
import pl.burno.selectionlauncher.ui.model.toUiAction

class MainViewModel(
    private val actionToggler: ActionToggler
) : ViewModel() {
    val uiActionsFlow = actionToggler.state.map { enabledActions ->
        enabledActions.map(EnabledAction::toUiAction)
    }

    fun onUiActionChanged(uiAction: UiAction, isEnabled: Boolean) {
        actionToggler.toggle(Action.fromName(uiAction.name), isEnabled)
    }
}