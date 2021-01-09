package pl.burno.selectionlauncher.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.burno.selectionlauncher.ui.components.main.MainScaffold
import pl.burno.selectionlauncher.ui.theme.SelectionLauncherTheme

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SelectionLauncherTheme {
                MainScaffold(
                    uiActionsFlow = viewModel.uiActionsFlow,
                    onUiActionChanged = viewModel::onUiActionChanged
                )
            }
        }
    }
}
