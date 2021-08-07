package ru.inc.myalarm

import android.app.Application
import ru.inc.myalarm.di.component.AppComponent
import ru.inc.myalarm.di.component.CreateSubComponent
import ru.inc.myalarm.di.component.DaggerAppComponent
import ru.inc.myalarm.di.module.main.AppModule

class MyApp : Application() {

    companion object {
        @get: Synchronized
        lateinit var instance: MyApp
            private set
    }

    lateinit var appComponent: AppComponent
        private set

    private var createSubComponent: CreateSubComponent? = null

    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    fun initCreateSubComponent() = appComponent.createSubComponent().also {
        createSubComponent = it
    }

    fun destroyCreateSubComponent() {
        createSubComponent = null
    }
}