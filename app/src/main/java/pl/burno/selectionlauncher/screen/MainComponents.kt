package pl.burno.selectionlauncher.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import kotlinx.coroutines.flow.Flow
import pl.burno.selectionlauncher.domain.Action

@Composable
fun Home(
    uiActionsFlow: Flow<List<UiAction>>,
    onUiActionChanged: (UiAction, Boolean) -> Unit
) {
    val uiActionsState = uiActionsFlow.collectAsState(listOf())
    val uiActions = uiActionsState.value
    if (uiActions.isNotEmpty()) {
        ActionList(uiActions, onUiActionChanged)
    } else {
        ProgressBar()
    }
}

@Composable
fun ProgressBar() {
    ConstraintLayout(Modifier.fillMaxWidth().fillMaxHeight()) {
        val progressIndicator = createRef()
        CircularProgressIndicator(
            Modifier.constrainAs(progressIndicator) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ActionList(
    uiActions: List<UiAction> = Action.values().map {
        UiAction.fromAction(it, false)
    },
    onUiActionChanged: (UiAction, Boolean) -> Unit = { _, _ -> }
) {
    LazyColumnFor(items = uiActions) { uiAction ->
        OptionSwitch(uiAction, onChanged = { onUiActionChanged(uiAction, it) })
    }
}

@Composable
fun OptionSwitch(uiAction: UiAction, onChanged: (Boolean) -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { onChanged(!uiAction.isEnabled) })
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(5.dp)),
            asset = vectorResource(id = uiAction.iconResId),
        )
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp),
            style = MaterialTheme.typography.body1,
            text = uiAction.name
        )
        Switch(
            modifier = Modifier.padding(end = 12.dp),
            checked = uiAction.isEnabled,
            onCheckedChange = onChanged
        )
    }
}

