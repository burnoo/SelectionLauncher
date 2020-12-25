package pl.burno.selectionlauncher.launcher

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import pl.burno.selectionlauncher.R

fun Activity.launchActionView(pkg: String, url: String) {
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
        launchAction(selection = selection)
    }

    abstract fun launchAction(selection: String)
}

