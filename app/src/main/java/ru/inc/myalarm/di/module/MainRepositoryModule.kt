package ru.inc.myalarm.di.module

import dagger.Module
import dagger.Provides
import ru.inc.myalarm.model.repositories.AlarmLocalDataSource
import ru.inc.myalarm.model.repositories.MainAlarmRepositoryImpl
import ru.inc.myalarm.view_model.main.MainAlarmRepository
import javax.inject.Singleton

@Module
class MainRepositoryModule {

    @Provides
    @Singleton
    fun mainRepositoryProvide(localDataSource: AlarmLocalDataSource): MainAlarmRepository =
        MainAlarmRepositoryImpl(localDataSource)
}