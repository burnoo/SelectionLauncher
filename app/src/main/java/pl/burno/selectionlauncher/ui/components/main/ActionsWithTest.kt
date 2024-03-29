package pl.burno.selectionlauncher.ui.components.main

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import pl.burno.selectionlauncher.ui.components.main.action.Actions
import pl.burno.selectionlauncher.ui.components.main.test.SelectionTest
import pl.burno.selectionlauncher.ui.model.UiAction
import pl.burno.selectionlauncher.ui.model.defaultUiActions

@Preview(showBackground = true)
@Composable
fun ActionsWithTest(
    uiActions: List<UiAction> = defaultUiActions,
    onUiActionChanged: (UiAction, Boolean) -> Unit = { _, _ -> }
) {
    val selectionTestTrigger = remember { mutableStateOf(1) }
    ConstraintLayout(Modifier.fillMaxWidth().fillMaxHeight()) {
        val (actionList, selectionTestText) = createRefs()
        Actions(
            modifier = Modifier.constrainAs(actionList) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            onUiActionChanged = { uiAction, isEnabled ->
                selectionTestTrigger.value++
                onUiActionChanged(uiAction, isEnabled)
            },
            uiActions = uiActions
        )
        SelectionTest(
            modifier = Modifier.constrainAs(selectionTestText) {
                top.linkTo(actionList.bottom)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            updateTrigger = selectionTestTrigger.value
        )
    }
}