package pl.burno.selectionlauncher.screen.components

import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun FullScreenProgressBar() {
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