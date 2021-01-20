package pl.burno.selectionlauncher.domain

data class EnabledAction(val action: Action, val isEnabled: Boolean)

enum class Action(val actionName: String) {
    Instagram("Instagram"),
    Snapchat("Snapchat");

    fun toEnabledAction(isEnabled: Boolean) = EnabledAction(this, isEnabled)

    companion object {
        fun fromName(name: String) = values().find { name == it.actionName }
            ?: throw IllegalArgumentException("Unsupported action \"$name\"")
    }
}