package pl.burno.selectionlauncher.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import pl.burno.selectionlauncher.ui.components.main.MainScaffold
import pl.burno.selectionlauncher.ui.theme.SelectionLauncherTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SelectionLauncherTheme {
                MainScaffold()
            }
        }
    }
}
