package pl.burno.selectionlauncher.ui.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import pl.burno.selectionlauncher.R

@Composable
fun AppBar() {
    val title = stringResource(id = R.string.app_name)
    TopAppBar(title = { Text(title) })
}