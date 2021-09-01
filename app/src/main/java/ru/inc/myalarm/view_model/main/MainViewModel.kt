package ru.inc.myalarm.view_model.main

import ru.inc.myalarm.extensions.viewModel
import ru.inc.myalarm.model.entity.ui.Alarm
import ru.inc.myalarm.model.repositories.AlarmServiceChange
import ru.inc.myalarm.view_model.BaseViewModel
import java.util.logging.Logger
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: MainAlarmRepository,
    private val alarmServiceChange: AlarmServiceChange
) : BaseViewModel<MainViewState>() {

    private val log = Logger.getLogger(MainViewModel::class.java.name)


    fun deleteAlarm(alarm: Alarm?) {
        alarm?.let {
            alarmServiceChange.deleteAlarm(it)
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
                mutableLiveData.postValue(MainViewState.Success(it))
            } else {
                mutableLiveData.postValue(MainViewState.FirstStart)
            }
        }, { it.printStackTrace() }))
    }
}