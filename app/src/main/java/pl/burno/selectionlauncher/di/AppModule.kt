package pl.burno.selectionlauncher.di

import android.content.pm.PackageManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import pl.burno.selectionlauncher.ActionToggler

val appModule = module {
    factory<PackageManager> { androidContext().packageManager }
    single { ActionToggler(get()) }
}