package pl.burno.selectionlauncher

enum class Action(val actionName: String) {
    Instagram("Instagram"),
    Snapchat("Snapchat");

    companion object {
        fun fromName(name: String) = values().find { name == it.actionName }
            ?: throw IllegalArgumentException("Unsupported action \"$name\"")
    }
}