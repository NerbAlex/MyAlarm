package ru.inc.myalarm.di.module.create

import dagger.Module
import dagger.Provides
import ru.inc.myalarm.di.scope.DetailsScope
import ru.inc.myalarm.model.repositories.AlarmLocalDataSource
import ru.inc.myalarm.model.repositories.CreateAlarmRepositoryImpl
import ru.inc.myalarm.view_model.create.CreateAlarmRepository

@Module
class CreateRepositoryModule {

    @Provides
    @DetailsScope
    fun createRepositoryProvide(localDataSource: AlarmLocalDataSource): CreateAlarmRepository =
        CreateAlarmRepositoryImpl(localDataSource)
}