package ru.inc.myalarm.view_model.create

import ru.inc.myalarm.MyApp
import ru.inc.myalarm.extensions.viewModel
import ru.inc.myalarm.model.entity.room.AlarmRoom
import ru.inc.myalarm.view_model.AppState
import ru.inc.myalarm.view_model.BaseViewModel
import java.util.logging.Logger
import javax.inject.Inject

class CreateAlarmViewModel: BaseViewModel<AppState.CreateAlarmViewState>() {

    private val log = Logger.getLogger(CreateAlarmViewModel::class.java.name)

    @Inject lateinit var repository: CreateAlarmRepository

    override fun startViewModel() {
        log.viewModel("startViewModel")
        MyApp.instance.initCreateSubComponent().inject(this)

        super.startViewModel()
    }

    fun createAlarm(alarm: AlarmRoom) {
        log.viewModel("createAlarm")

        repository.saveAlarm(alarm).subscribe ({
            mutableLiveData.postValue(AppState.CreateAlarmViewState.AlarmCreated)
        }, {
            it.printStackTrace()
        })
    }

    override fun onCleared() {
        MyApp.instance.destroyCreateSubComponent()
        super.onCleared()
    }

}