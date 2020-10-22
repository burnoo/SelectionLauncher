package pl.burno.selectionlauncher

data class UiAction(
    val name: String,
    val iconResId: Int,
    val isEnabled: Boolean
) {

    companion object {

        fun fromAction(action: Action, isEnabled: Boolean) = when(action) {
            Action.Instagram -> UiAction(action.actionName, R.drawable.ic_instagram, isEnabled)
            Action.Snapchat -> UiAction(action.actionName, R.drawable.ic_snapchat, isEnabled)
        }
    }
}
