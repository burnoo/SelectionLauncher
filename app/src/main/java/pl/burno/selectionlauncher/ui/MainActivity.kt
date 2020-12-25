package pl.burno.selectionlauncher.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.koin.android.ext.android.get
import pl.burno.selectionlauncher.ActionToggler
import pl.burno.selectionlauncher.domain.Action
import pl.burno.selectionlauncher.ui.components.main.MainScaffold
import pl.burno.selectionlauncher.ui.model.UiAction
import pl.burno.selectionlauncher.ui.theme.SelectionLauncherTheme

class MainActivity : AppCompatActivity() {

    private val actionToggler = get<ActionToggler>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val uiActionsFlow = actionToggler.state.toUiActionsFlow()
        setContent {
            SelectionLauncherTheme {
                MainScaffold(uiActionsFlow = uiActionsFlow, onUiActionChanged = ::mapAndToggle)
            }
        }
    }

    private fun Flow<List<Pair<Action, Boolean>>>.toUiActionsFlow() = map { actionsWithState ->
        actionsWithState.map { (action, isEnabled) -> UiAction.fromAction(action, isEnabled) }
    }

    private fun mapAndToggle(uiAction: UiAction, isEnabled: Boolean) {
        actionToggler.toggle(Action.fromName(uiAction.name), isEnabled)
    }
}
