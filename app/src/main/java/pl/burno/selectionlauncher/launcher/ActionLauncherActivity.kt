package pl.burno.selectionlauncher.launcher

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import pl.burno.selectionlauncher.R

fun Activity.launchAction(pkg: String, url: String) {
    val uri = url.toUri()
    val intent = Intent(Intent.ACTION_VIEW, uri)
    intent.setPackage(pkg)
    val isIntentAvailable = packageManager
        .queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)
        .isNotEmpty()
    if (isIntentAvailable) {
        startActivity(intent)
    } else {
        startActivity(Intent(Intent.ACTION_VIEW, uri))
    }
}

abstract class ActionLauncherActivity : AppCompatActivity(R.layout.activity_launcher) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val selection = intent.getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT)!!.toString()
        finish()
        val text = extractText(selection) ?: return
        launch(text)
    }

    private fun extractText(selection: String): String? {
        return Regex("[a-z0-9._]{1,30}", RegexOption.IGNORE_CASE)
            .findAll(selection)
            .lastOrNull()
            ?.value
    }

    abstract fun launch(text: String)
}

