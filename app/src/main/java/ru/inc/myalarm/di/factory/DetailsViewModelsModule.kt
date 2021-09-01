package ru.inc.myalarm.di.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.inc.myalarm.view_model.create.CreateAlarmViewModel
import javax.inject.Named

@Module
interface DetailsViewModelsModule {

    @Binds
    @Named(ConstFactory.DETAILS)
    fun bindCreateViewModuleFactory(factory: DetailsViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CreateAlarmViewModel::class)
    fun createViewModel(createAlarmViewModel: CreateAlarmViewModel): ViewModel
}