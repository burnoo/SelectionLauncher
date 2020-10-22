package pl.burno.selectionlauncher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import kotlinx.coroutines.flow.map
import org.koin.android.ext.android.get

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val actionToggler = get<ActionToggler>()
        val actionUiItemsFlow = actionToggler.state.map { list ->
            list.map { (action, isEnabled) -> UiAction.fromAction(action, isEnabled) }
        }
        setContent {
            Home(
                uiActionsFlow = actionUiItemsFlow,
                onUiActionChanged = { actionUiItem, isEnabled ->
                    actionToggler.toggle(Action.fromName(actionUiItem.name), isEnabled)
                }
            )
        }
    }
}

