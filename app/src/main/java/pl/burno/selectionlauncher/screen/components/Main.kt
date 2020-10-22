package pl.burno.selectionlauncher.screen.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.flow.Flow
import pl.burno.selectionlauncher.screen.UiAction

@Composable
fun Main(uiActionsFlow: Flow<List<UiAction>>, onUiActionChanged: (UiAction, Boolean) -> Unit) {
    val uiActionsState = uiActionsFlow.collectAsState(listOf())
    val uiActions = uiActionsState.value
    if (uiActions.isNotEmpty()) {
        Actions(uiActions, onUiActionChanged)
    } else {
        FullScreenProgressBar()
    }
}