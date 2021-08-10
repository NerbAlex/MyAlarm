package ru.inc.myalarm.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import ru.inc.myalarm.extensions.viewModel
import java.util.logging.Logger

abstract class BaseViewModel<T : AppState>(
    protected val mutableLiveData: MutableLiveData<T> = MutableLiveData(),
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()
): ViewModel() {
    private val log = Logger.getLogger(BaseViewModel::class.java.name)

    open fun getData(): LiveData<T> = mutableLiveData

    override fun onCleared() {
        log.viewModel("onCleared")
        compositeDisposable.clear()
        super.onCleared()
    }

    open fun startViewModel() {
        log.viewModel("startViewModel")

    }
}