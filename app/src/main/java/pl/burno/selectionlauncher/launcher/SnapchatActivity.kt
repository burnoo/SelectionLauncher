package pl.burno.selectionlauncher.launcher

class SnapchatActivity : ActionLauncherActivity() {

    override fun launchAction(selection: String) = launchActionView(
        pkg = "com.snapchat.android",
        url = "https://snapchat.com/add/$selection"
    )
}