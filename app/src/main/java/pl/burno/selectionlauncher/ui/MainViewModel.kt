package pl.burno.selectionlauncher.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import pl.burno.selectionlauncher.ActionToggler
import pl.burno.selectionlauncher.domain.Action
import pl.burno.selectionlauncher.ui.model.UiAction

class MainViewModel(
    private val actionToggler: ActionToggler
) : ViewModel() {
    val uiActionsFlow = actionToggler.state.toUiActionsFlow()

    fun onUiActionChanged(uiAction: UiAction, isEnabled: Boolean) {
        actionToggler.toggle(Action.fromName(uiAction.name), isEnabled)
    }

    private fun Flow<List<Pair<Action, Boolean>>>.toUiActionsFlow() = map { actionsWithState ->
        actionsWithState.map { (action, isEnabled) -> UiAction.fromAction(action, isEnabled) }
    }
}