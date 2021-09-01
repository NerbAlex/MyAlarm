package ru.inc.myalarm.di.module

import dagger.Module
import dagger.Provides
import ru.inc.myalarm.MyApp
import ru.inc.myalarm.alarm_manager.service.AlarmService
import ru.inc.myalarm.model.repositories.AlarmServiceChange
import javax.inject.Singleton


@Module
class AlarmMainModule {

    @Provides
    @Singleton
    fun alarmServiceProvide(app: MyApp) = AlarmService(app.applicationContext)

    @Provides
    @Singleton
    fun alarmServiceChange(alarmService: AlarmService): AlarmServiceChange = alarmService
}