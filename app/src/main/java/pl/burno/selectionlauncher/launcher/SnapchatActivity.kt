package pl.burno.selectionlauncher.launcher

class SnapchatActivity : ActionLauncherActivity() {

    override fun launch(text: String) = launchAction(
        pkg = "com.snapchat.android",
        url = "https://snapchat.com/add/$text"
    )
}