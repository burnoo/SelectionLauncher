package pl.burno.selectionlauncher.screen.components

import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    ConstraintLayout(Modifier.fillMaxWidth().fillMaxHeight()) {
        val (actionList, testText) = createRefs()
        Actions(
            uiActions = uiActions,
            onUiActionChanged = onUiActionChanged,
            modifier = Modifier.constrainAs(actionList) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        Test(Modifier.constrainAs(testText) {
            val sideMargin = 16.dp
            top.linkTo(actionList.bottom)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start, margin = sideMargin)
            end.linkTo(parent.end, margin = sideMargin)
        })
//        CircularProgressIndicator(
//            Modifier.constrainAs(progressIndicator) {
//                top.linkTo(parent.top)
//                bottom.linkTo(parent.bottom)
//                start.linkTo(parent.start)
//                end.linkTo(parent.end)
//            }
//        )
    }
}