package pl.burno.selectionlauncher

sealed class ActionUiItem(val isEnabled: Boolean) {
    abstract val name: String
    abstract val iconResId: Int

    class Instagram(isEnabled: Boolean) : ActionUiItem(isEnabled) {
        override val name = "Instagram"
        override val iconResId = R.drawable.ic_instagram
    }

    class Snapchat(isEnabled: Boolean) : ActionUiItem(isEnabled) {
        override val name = "Snapchat"
        override val iconResId = R.drawable.ic_snapchat
    }

    companion object {
        fun fromName(name: String, isEnabled: Boolean): ActionUiItem {
            return when(name) {
                "Instagram" -> Instagram(isEnabled)
                "Snapchat" -> Snapchat(isEnabled)
                else -> throw IllegalAccessException("$name is not supported action")
            }
        }
    }
}

val defaultActionUiItems = listOf(
    ActionUiItem.Instagram(true),
    ActionUiItem.Snapchat(true)
)
