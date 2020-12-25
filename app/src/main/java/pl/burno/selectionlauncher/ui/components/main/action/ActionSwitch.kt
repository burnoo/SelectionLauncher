package pl.burno.selectionlauncher.ui.components.main.action

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.burno.selectionlauncher.domain.Action
import pl.burno.selectionlauncher.ui.model.UiAction

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun ActionSwitch(
    uiAction: UiAction = UiAction.fromAction(Action.Instagram, true),
    onChanged: (Boolean) -> Unit = {}
) {
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
            imageVector = vectorResource(id = uiAction.iconResId),
        )
        BasicText(
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

