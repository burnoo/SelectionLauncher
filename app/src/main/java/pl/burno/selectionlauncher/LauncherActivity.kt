package pl.burno.selectionlauncher

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

abstract class LauncherActivity : AppCompatActivity(R.layout.activity_launcher) {
    protected abstract val pkg: String
    protected abstract fun createUri(text: String) : Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val selection = intent.getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT)!!.toString()
        finish()
        launchAction(selection = selection)
    }

    private fun launchAction(selection: String) {
        val uri = createUri(selection)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.setPackage(pkg)
        if (isIntentAvailable(intent)) {
            startActivity(intent)
        } else {
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }
    }

    private fun isIntentAvailable(intent: Intent): Boolean {
        val list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)
        return list.isNotEmpty()
    }
}

class InstagramActivity : LauncherActivity() {
    override val pkg = "com.instagram.android"
    override fun createUri(text: String): Uri =
        Uri.parse("https://instagram.com/_u/$text")
}

class SnapchatActivity : LauncherActivity() {
    override val pkg = "com.snapchat.android"
    override fun createUri(text: String): Uri =
        Uri.parse("https://snapchat.com/add/$text")
}