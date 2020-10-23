package pl.burno.selectionlauncher.screen.components

import android.view.LayoutInflater
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.ui.tooling.preview.Preview
import pl.burno.selectionlauncher.R

@Preview(showBackground = true)
@Composable
fun Test() {
    AndroidView(
        viewBlock = { LayoutInflater.from(it).inflate(R.layout.layout_test, null) },
        modifier = Modifier.fillMaxWidth()
    )
}