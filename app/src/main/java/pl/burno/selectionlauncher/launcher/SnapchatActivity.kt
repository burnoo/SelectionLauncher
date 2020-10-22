package pl.burno.selectionlauncher.launcher

import android.net.Uri

class SnapchatActivity : LauncherActivity() {
    override val pkg = "com.snapchat.android"
    override fun createUri(text: String): Uri =
        Uri.parse("https://snapchat.com/add/$text")
}