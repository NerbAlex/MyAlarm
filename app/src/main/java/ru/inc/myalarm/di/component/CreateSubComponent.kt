package ru.inc.myalarm.di.component

import dagger.Subcomponent
import ru.inc.myalarm.di.factory.DetailsViewModelsModule
import ru.inc.myalarm.di.module.AlarmCreateModule
import ru.inc.myalarm.di.module.create.CreateRepositoryModule
import ru.inc.myalarm.di.scope.DetailsScope
import ru.inc.myalarm.ui.create.CreateAlarmActivity

@DetailsScope
@Subcomponent(
    modules = [
        DetailsViewModelsModule::class,
        CreateRepositoryModule::class,
        AlarmCreateModule::class
    ]
)
interface CreateSubComponent {

    fun inject(createAlarmActivity: CreateAlarmActivity)
}