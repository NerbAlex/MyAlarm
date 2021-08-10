package ru.inc.myalarm.view_model.main

import ru.inc.myalarm.MyApp
import ru.inc.myalarm.extensions.viewModel
import ru.inc.myalarm.view_model.AppState
import ru.inc.myalarm.view_model.BaseViewModel
import java.util.logging.Logger
import javax.inject.Inject

class MainViewModel : BaseViewModel<AppState.MainViewState>() {

    @Inject
    lateinit var repository: MainAlarmRepository

    private val log = Logger.getLogger(MainViewModel::class.java.name)

    init {
        log.viewModel("init")
        MyApp.instance.appComponent.inject(this)
    }


    override fun startViewModel() {
//        log.viewModel("startViewModel")

        compositeDisposable.add(repository.getData().subscribe({
            if (it.isNotEmpty()) {
                mutableLiveData.postValue(AppState.MainViewState.Success(it))
            } else {
                mutableLiveData.postValue(AppState.MainViewState.FirstStart)
            }
        }, { it.printStackTrace() }))
        return super.startViewModel()
    }
}