package ru.inc.myalarm.di.factory

import androidx.lifecycle.ViewModel
import ru.inc.myalarm.di.scope.DetailsScope
import javax.inject.Inject
import javax.inject.Provider

@DetailsScope
class DetailsViewModelFactory @Inject constructor(viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>) :
    BaseModelFactory(viewModels)
