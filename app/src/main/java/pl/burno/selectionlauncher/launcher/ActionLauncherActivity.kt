package pl.burno.selectionlauncher.launcher

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pl.burno.selectionlauncher.R

abstract class ActionLauncherActivity : AppCompatActivity(R.layout.activity_launcher) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val selection = intent.getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT)!!.toString()
        finish()
        val text = SelectionExtractor.extract(selection) ?: return
        launch(text)
    }

    abstract fun launch(text: String)
}