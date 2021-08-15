package ru.inc.myalarm.di.module

import dagger.Module
import dagger.Provides
import ru.inc.myalarm.MyApp
import ru.inc.myalarm.alarm_manager.service.AlarmService
import ru.inc.myalarm.di.scope.CreateScope
import ru.inc.myalarm.model.repositories.AlarmServiceChange
import ru.inc.myalarm.model.repositories.AlarmServiceCreate
import javax.inject.Singleton


@Module
class AlarmModule {

    @Provides
    @Singleton
    fun alarmServiceProvide(app: MyApp) = AlarmService(app.applicationContext)

    @Provides
    @CreateScope
    fun alarmServiceCreateProvide(alarmService: AlarmService): AlarmServiceCreate = alarmService

    @Provides
    @Singleton
    fun  alarmServiceChange(alarmService: AlarmService): AlarmServiceChange = alarmService
}