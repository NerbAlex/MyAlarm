package ru.inc.myalarm.di.module

import dagger.Module
import dagger.Provides
import ru.inc.myalarm.alarm_manager.service.AlarmService
import ru.inc.myalarm.di.scope.DetailsScope
import ru.inc.myalarm.model.repositories.AlarmServiceCreate

@Module
class AlarmCreateModule {

    @Provides
    @DetailsScope
    fun alarmServiceCreateProvide(alarmService: AlarmService): AlarmServiceCreate = alarmService
}