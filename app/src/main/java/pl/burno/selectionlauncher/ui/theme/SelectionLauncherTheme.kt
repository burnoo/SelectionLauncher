package pl.burno.selectionlauncher.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val indigo500 = Color(0xFF3F51B5)
val indigo700 = Color(0xFF303F9F)
val amber500 = Color(0xFFFFC107)
val amber700 = Color(0xFFFFA000)

private val LightColorPalette = lightColors(
    primary = indigo500,
    primaryVariant = indigo700,
    secondary = amber500,
    secondaryVariant = amber700

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun SelectionLauncherTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = LightColorPalette,
        content = content
    )
}