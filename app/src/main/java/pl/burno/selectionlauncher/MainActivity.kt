package pl.burno.selectionlauncher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.map


@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val actionStates = ActionToggler(packageManager)
        val actionUiItemsFlow = actionStates.state.map { list ->
            list.map { (action, isEnabled) -> UiAction.fromAction(action, isEnabled) }
        }
        setContent {
            Home(
                uiActionsFlow = actionUiItemsFlow,
                onUiActionChanged = { actionUiItem, isEnabled ->
                    actionStates.toggle(actionUiItem.name, isEnabled)
                }
            )
        }
    }
}

