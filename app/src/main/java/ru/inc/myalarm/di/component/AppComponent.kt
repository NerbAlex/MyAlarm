package ru.inc.myalarm.di.component

import dagger.Component
import ru.inc.myalarm.di.module.main.AppModule
import ru.inc.myalarm.di.module.main.DataBaseModule
import ru.inc.myalarm.di.module.main.MainRepositoryModule
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
    fun createSubComponent(): CreateSubComponent
    fun inject(mainViewModel: MainViewModel)
}