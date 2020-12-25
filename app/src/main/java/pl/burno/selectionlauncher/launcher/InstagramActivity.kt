package pl.burno.selectionlauncher.launcher

class InstagramActivity : ActionLauncherActivity() {

    override fun launchSelection(selection: String) = launchAction(
        pkg = "com.instagram.android",
        url = "https://instagram.com/_u/$selection"
    )
}