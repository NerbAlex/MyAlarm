package ru.inc.myalarm.di.module

import dagger.Module
import dagger.Provides
import ru.inc.myalarm.MyApp
import javax.inject.Singleton

@Module
class AppModule(val app: MyApp) {

    @Provides
    @Singleton
    fun appProvide(): MyApp = app
}