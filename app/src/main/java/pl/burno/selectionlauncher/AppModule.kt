package pl.burno.selectionlauncher

import android.content.pm.PackageManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    factory<PackageManager> { androidContext().packageManager }
    factory { ActionToggler(get()) }
}