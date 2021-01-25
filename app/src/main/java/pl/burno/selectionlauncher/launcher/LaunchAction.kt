package pl.burno.selectionlauncher.launcher

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import androidx.core.net.toUri

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