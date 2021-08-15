package ru.inc.myalarm.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import ru.inc.myalarm.extensions.lifecycle
import ru.inc.myalarm.model.entity.ui.Alarm
import ru.inc.myalarm.view_model.main.MainViewModel
import java.util.logging.Logger

abstract class BaseViewModel<T : AppState>(
    protected val mutableLiveData: MutableLiveData<T> = MutableLiveData(),
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()
): ViewModel() {
    open fun getData(): LiveData<T> = mutableLiveData

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

    open fun startViewModel() {}
}