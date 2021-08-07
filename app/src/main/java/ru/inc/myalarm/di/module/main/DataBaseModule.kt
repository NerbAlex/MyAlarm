package ru.inc.myalarm.di.module.main

import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.inc.myalarm.MyApp
import ru.inc.myalarm.model.data.cache.AlarmCache
import ru.inc.myalarm.model.database.DataBase
import ru.inc.myalarm.model.repositories.AlarmLocalDataSource
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun databaseProvide(app: MyApp) = Room.databaseBuilder(app, DataBase::class.java, DataBase.NAME).build()

    @Provides
    @Singleton
    fun alarmCacheProvide(db: DataBase): AlarmLocalDataSource = AlarmCache(db)

}