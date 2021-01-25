package pl.burno.selectionlauncher.launcher

class InstagramActivity : ActionLauncherActivity() {

    override fun launch(text: String) = launchAction(
        pkg = "com.instagram.android",
        url = "https://instagram.com/_u/$text"
    )
}