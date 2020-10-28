package pl.burno.selectionlauncher.screen.components

import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.ui.tooling.preview.Preview
import kotlinx.coroutines.flow.Flow
import pl.burno.selectionlauncher.domain.Action
import pl.burno.selectionlauncher.screen.UiAction

@Composable
fun Main(uiActionsFlow: Flow<List<UiAction>>, onUiActionChanged: (UiAction, Boolean) -> Unit) {
    val uiActionsState = uiActionsFlow.collectAsState(listOf())
    val uiActions = uiActionsState.value
    if (uiActions.isNotEmpty()) {
        MainLayout(uiActions, onUiActionChanged)
    } else {
        FullScreenProgressBar()
    }
}

@Preview(showBackground = true)
@Composable
fun MainLayout(
    uiActions: List<UiAction> = Action.values().map {
        UiAction.fromAction(it, false)
    },
    onUiActionChanged: (UiAction, Boolean) -> Unit = { _, _ -> }
) {
    val selectionTestTrigger = remember { mutableStateOf(1) }
    ConstraintLayout(Modifier.fillMaxWidth().fillMaxHeight()) {
        val (actionList, selectionTestText) = createRefs()
        Actions(
            uiActions = uiActions,
            onUiActionChanged = { uiAction, isEnabled ->
                selectionTestTrigger.value++
                onUiActionChanged(uiAction, isEnabled)
            },
            modifier = Modifier.constrainAs(actionList) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        SelectionTest(
            updateTrigger = selectionTestTrigger.value,
            modifier = Modifier.constrainAs(selectionTestText) {
                top.linkTo(actionList.bottom)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
    }
}