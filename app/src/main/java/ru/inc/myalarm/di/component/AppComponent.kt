package ru.inc.myalarm.di.component

import dagger.Component
import ru.inc.myalarm.di.module.AppModule
import ru.inc.myalarm.di.module.DataBaseModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        DataBaseModule::class
    ]
)
interface AppComponent {

}