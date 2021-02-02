package pl.burno.selectionlauncher.ui.components.main.action

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pl.burno.selectionlauncher.ui.model.UiAction
import pl.burno.selectionlauncher.ui.model.defaultUiActions

@Preview(showBackground = true)
@Composable
fun Actions(
    modifier: Modifier = Modifier,
    onUiActionChanged: (UiAction, Boolean) -> Unit = { _, _ -> },
    uiActions: List<UiAction> = defaultUiActions
) {
    LazyColumn(modifier = modifier) {
        items(uiActions) { uiAction ->
            ActionSwitch(uiAction, onChanged = { onUiActionChanged(uiAction, it) })
        }
    }
}