package pl.burno.selectionlauncher.di

import android.content.pm.PackageManager
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.burno.selectionlauncher.ActionToggler
import pl.burno.selectionlauncher.ui.MainViewModel

val appModule = module {
    factory<PackageManager> { androidContext().packageManager }
    single { ActionToggler(get()) }
    viewModel { MainViewModel(get()) }
}