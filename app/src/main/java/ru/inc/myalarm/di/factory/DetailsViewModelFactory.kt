package ru.inc.myalarm.di.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.inc.myalarm.di.scope.DetailsScope
import java.lang.IllegalArgumentException
import javax.inject.Inject
import javax.inject.Provider

@DetailsScope
class DetailsViewModelFactory @Inject constructor(
    private val viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>,
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val provider = viewModels[modelClass]
            ?: throw IllegalArgumentException("Unknown model class $modelClass")

        return provider.get() as T
    }
}