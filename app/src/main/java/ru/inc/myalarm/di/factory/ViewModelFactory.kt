package ru.inc.myalarm.di.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.inc.myalarm.model.repositories.AlarmServiceChange
import ru.inc.myalarm.view_model.main.MainAlarmRepository
import ru.inc.myalarm.view_model.main.MainViewModel
import java.lang.IllegalArgumentException
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class ViewModelFactory @Inject constructor(
    private val viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>,
): ViewModelProvider.Factory {
//some changes
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val provider = viewModels[modelClass]
            ?: throw IllegalArgumentException("Unknown model class $modelClass")

        return provider.get() as T
    }
}