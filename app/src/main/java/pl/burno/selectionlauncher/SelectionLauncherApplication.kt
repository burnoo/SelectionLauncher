package pl.burno.selectionlauncher

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SelectionLauncherApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@SelectionLauncherApplication)
            modules(appModule)
        }
    }
}