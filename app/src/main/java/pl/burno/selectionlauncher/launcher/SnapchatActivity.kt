package pl.burno.selectionlauncher.launcher

class SnapchatActivity : ActionLauncherActivity() {

    override fun launchSelection(selection: String) = launchAction(
        pkg = "com.snapchat.android",
        url = "https://snapchat.com/add/$selection"
    )
}