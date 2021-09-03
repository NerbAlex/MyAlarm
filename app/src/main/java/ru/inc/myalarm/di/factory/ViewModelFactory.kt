package ru.inc.myalarm.di.factory

import androidx.lifecycle.ViewModel
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class ViewModelFactory @Inject constructor(viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>) :
    BaseModelFactory(viewModels)