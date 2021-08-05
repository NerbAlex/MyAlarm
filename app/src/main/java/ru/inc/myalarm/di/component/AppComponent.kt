package ru.inc.myalarm.di.component

import dagger.Component
import ru.inc.myalarm.di.module.AppModule
import ru.inc.myalarm.di.module.DataBaseModule
import ru.inc.myalarm.di.module.MainRepositoryModule
import ru.inc.myalarm.view_model.main.MainViewModel
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        MainRepositoryModule::class,
        DataBaseModule::class
    ]
)
interface AppComponent {
    fun inject(mainViewModel: MainViewModel)
}