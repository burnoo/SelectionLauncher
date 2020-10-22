package pl.burno.selectionlauncher.launcher

import android.net.Uri

class InstagramActivity : LauncherActivity() {
    override val pkg = "com.instagram.android"
    override fun createUri(text: String): Uri =
        Uri.parse("https://instagram.com/_u/$text")
}