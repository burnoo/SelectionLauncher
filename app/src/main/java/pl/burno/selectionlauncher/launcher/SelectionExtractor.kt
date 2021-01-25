package pl.burno.selectionlauncher.launcher

object SelectionExtractor {

    fun extract(selection: String): String? =
        Regex("[a-z0-9._]{1,30}", RegexOption.IGNORE_CASE)
            .findAll(selection)
            .lastOrNull()
            ?.value
}