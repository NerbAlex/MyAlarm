package ru.inc.myalarm

import android.app.Application
import ru.inc.myalarm.di.component.AppComponent
import ru.inc.myalarm.di.component.DaggerAppComponent
import ru.inc.myalarm.di.module.AppModule

class MyApp: Application() {

    companion object {
        @get: Synchronized
        lateinit var instance: MyApp
            private set
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}