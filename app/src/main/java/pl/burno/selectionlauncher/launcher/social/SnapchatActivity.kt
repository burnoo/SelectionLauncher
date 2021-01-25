package pl.burno.selectionlauncher.launcher.social

import pl.burno.selectionlauncher.launcher.ActionLauncherActivity
import pl.burno.selectionlauncher.launcher.launchAction

class SnapchatActivity : ActionLauncherActivity() {

    override fun launch(text: String) = launchAction(
        pkg = "com.snapchat.android",
        url = "https://snapchat.com/add/$text"
    )
}