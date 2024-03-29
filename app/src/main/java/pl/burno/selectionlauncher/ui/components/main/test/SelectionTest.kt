package pl.burno.selectionlauncher.ui.components.main.test

import android.view.LayoutInflater
import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.tooling.preview.Preview
import pl.burno.selectionlauncher.R

@Preview(showBackground = true)
@Composable
fun SelectionTest(modifier: Modifier = Modifier, updateTrigger: Int = 1) {
    AndroidView(
        factory = {
            LayoutInflater.from(it).inflate(R.layout.layout_test, null) as TextView
        },
        modifier = modifier,
        update = {
            // WORKAROUND: this forces clearing focus execution on each action toggle
            updateTrigger.toString()
            it.clearFocus()
        }
    )
}