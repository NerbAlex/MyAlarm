package ru.inc.myalarm.di.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.inc.myalarm.view_model.create.CreateAlarmViewModel
import ru.inc.myalarm.view_model.main.MainViewModel
import javax.inject.Named

@Module
interface ViewModelsModule {

    /**
     * [Binds] - Принимает только один аргумент
     */
    @Binds
    @Named(ConstFactory.MAIN)
    fun bindViewModuleFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun mainViewModel(mainViewModel: MainViewModel): ViewModel
}