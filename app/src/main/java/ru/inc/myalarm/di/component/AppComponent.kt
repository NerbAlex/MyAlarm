package ru.inc.myalarm.di.component

import dagger.Component
import ru.inc.myalarm.alarm_manager.receiver.AlarmReceiver
import ru.inc.myalarm.di.factory.ViewModelsModule
import ru.inc.myalarm.di.module.AlarmMainModule
import ru.inc.myalarm.di.module.main.AppModule
import ru.inc.myalarm.di.module.main.DataBaseModule
import ru.inc.myalarm.di.module.main.MainRepositoryModule
import ru.inc.myalarm.ui.main.MainActivity
import ru.inc.myalarm.view_model.main.MainViewModel
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        MainRepositoryModule::class,
        ViewModelsModule::class,
        DataBaseModule::class,
        AlarmMainModule::class
    ]
)
interface AppComponent {
    fun createSubComponent(): CreateSubComponent
//    fun inject(alarmReceiver: AlarmReceiver)  TODO
    fun inject(mainActivity: MainActivity)
}