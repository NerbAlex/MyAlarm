package ru.inc.myalarm.view_model.main

import ru.inc.myalarm.MyApp
import ru.inc.myalarm.extensions.viewModel
import ru.inc.myalarm.model.entity.ui.Alarm
import ru.inc.myalarm.model.repositories.AlarmServiceChange
import ru.inc.myalarm.view_model.AppState
import ru.inc.myalarm.view_model.BaseViewModel
import java.util.logging.Logger
import javax.inject.Inject

class MainViewModel : BaseViewModel<AppState.MainViewState>() {

    @Inject
    lateinit var repository: MainAlarmRepository

    @Inject
    lateinit var alarmServiceChange: AlarmServiceChange
    private val log = Logger.getLogger(MainViewModel::class.java.name)

    init {
        MyApp.instance.appComponent.inject(this)
    }

    fun deleteAlarm(alarm: Alarm?) {
        alarm.let {
            var currentAlarm = Alarm(
                id = 0,
                name = it!!.name,
                date = it.date,
                requestCode = it.requestCode,
                repeatStatus = it.repeatStatus,
                changeLongDate = it.changeLongDate
            )
            alarmServiceChange.deleteAlarm(currentAlarm)
            compositeDisposable.add(
                repository.deleteAlarm(it).subscribe {
                    startViewModel()
                })
        }


    }

    override fun startViewModel() {
        log.viewModel("startViewModel")

        compositeDisposable.clear()
        compositeDisposable.add(repository.getData().subscribe({
            if (it.isNotEmpty()) {
                mutableLiveData.postValue(AppState.MainViewState.Success(it))
            } else {
                mutableLiveData.postValue(AppState.MainViewState.FirstStart)
            }
        }, { it.printStackTrace() }))
    }
}