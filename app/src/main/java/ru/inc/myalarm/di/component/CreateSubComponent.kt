package ru.inc.myalarm.di.component

import dagger.Subcomponent
import ru.inc.myalarm.di.module.create.CreateRepositoryModule
import ru.inc.myalarm.di.scope.CreateScope
import ru.inc.myalarm.view_model.create.CreateAlarmViewModel

@CreateScope
@Subcomponent(modules = [
        CreateRepositoryModule::class
])
interface CreateSubComponent {

    fun inject(createAlarmViewModel: CreateAlarmViewModel)
}