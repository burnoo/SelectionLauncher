package pl.burno.selectionlauncher.launcher.social

import pl.burno.selectionlauncher.launcher.ActionLauncherActivity
import pl.burno.selectionlauncher.launcher.launchAction

class InstagramActivity : ActionLauncherActivity() {

    override fun launch(text: String) = launchAction(
        pkg = "com.instagram.android",
        url = "https://instagram.com/_u/$text"
    )
}