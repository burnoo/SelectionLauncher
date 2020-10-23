package pl.burno.selectionlauncher.screen.components

import android.view.LayoutInflater
import android.widget.TextView
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.ui.tooling.preview.Preview
import pl.burno.selectionlauncher.R

@Preview(showBackground = true)
@Composable
fun Test(decoy: Int = 1, modifier: Modifier = Modifier) {
    AndroidView(
        viewBlock = {
            LayoutInflater.from(it).inflate(R.layout.layout_test, null) as TextView
        },
        modifier = modifier.fillMaxWidth(),
        update = {
            // WORKAROUND: this forces clearing focus to execute on each action toggle
            decoy.toString()
            it.clearFocus()
        }
    )
}