package pl.burno.selectionlauncher.launcher

class InstagramActivity : ActionLauncherActivity() {

    override fun launchAction(selection: String) = launchActionView(
        pkg = "com.instagram.android",
        url = "https://instagram.com/_u/$selection"
    )
}