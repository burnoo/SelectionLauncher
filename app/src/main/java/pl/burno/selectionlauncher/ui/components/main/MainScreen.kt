package pl.burno.selectionlauncher.ui.components.main

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.flow.Flow
import pl.burno.selectionlauncher.ui.components.AppBar
import pl.burno.selectionlauncher.ui.components.main.progress.FullScreenProgressBar
import pl.burno.selectionlauncher.ui.model.UiAction

@Composable
fun MainScaffold(
    uiActionsFlow: Flow<List<UiAction>>,
    onUiActionChanged: (UiAction, Boolean) -> Unit
) {
    Scaffold(topBar = { AppBar() }, bodyContent = {
        MainScreen(uiActionsFlow = uiActionsFlow, onUiActionChanged = onUiActionChanged)
    })
}

@Composable
fun MainScreen(
    uiActionsFlow: Flow<List<UiAction>>,
    onUiActionChanged: (UiAction, Boolean) -> Unit
) {
    val uiActionsState = uiActionsFlow.collectAsState(listOf())
    val uiActions = uiActionsState.value
    if (uiActions.isNotEmpty()) {
        ActionsWithTest(uiActions, onUiActionChanged)
    } else {
        FullScreenProgressBar()
    }
}