package pl.burno.selectionlauncher.ui.components.main

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import org.koin.androidx.compose.getViewModel
import pl.burno.selectionlauncher.ui.MainViewModel
import pl.burno.selectionlauncher.ui.components.AppBar
import pl.burno.selectionlauncher.ui.components.main.progress.FullScreenProgressBar

@Composable
fun MainScaffold() {
    Scaffold(topBar = { AppBar() }, content = {
        MainScreen()
    })
}

@Composable
fun MainScreen() {
    val viewModel = getViewModel<MainViewModel>()
    val uiActionsState = viewModel.uiActionsFlow.collectAsState(listOf())
    val uiActions = uiActionsState.value
    if (uiActions.isNotEmpty()) {
        ActionsWithTest(uiActions, viewModel::onUiActionChanged)
    } else {
        FullScreenProgressBar()
    }
}