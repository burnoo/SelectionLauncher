package pl.burno.selectionlauncher

data class ActionUiItem(
    val name: String,
    val iconResId: Int,
    val isEnabled: Boolean
) {

    companion object {
        fun fromName(name: String, isEnabled: Boolean): ActionUiItem {
            return when(name) {
                "Instagram" -> ActionUiItem(name, R.drawable.ic_instagram, isEnabled)
                "Snapchat" -> ActionUiItem(name, R.drawable.ic_snapchat, isEnabled)
                else -> throw IllegalAccessException("$name is not supported action")
            }
        }
    }
}
