package pl.burno.selectionlauncher.screen.components

import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.runtime.Composable
import androidx.ui.tooling.preview.Preview
import pl.burno.selectionlauncher.domain.Action
import pl.burno.selectionlauncher.screen.UiAction

@Preview(showBackground = true)
@Composable
fun Actions(
    uiActions: List<UiAction> = Action.values().map {
        UiAction.fromAction(it, false)
    },
    onUiActionChanged: (UiAction, Boolean) -> Unit = { _, _ -> }
) {
    LazyColumnFor(items = uiActions) { uiAction ->
        OptionSwitch(uiAction, onChanged = { onUiActionChanged(uiAction, it) })
    }
}