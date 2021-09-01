package ru.inc.myalarm.view_model.create

import ru.inc.myalarm.extensions.toMyFormat
import ru.inc.myalarm.extensions.viewModel
import ru.inc.myalarm.model.entity.ConstRepeatStatus
import ru.inc.myalarm.model.entity.room.AlarmRoom
import ru.inc.myalarm.model.entity.ui.Alarm
import ru.inc.myalarm.model.repositories.AlarmServiceCreate
import ru.inc.myalarm.view_model.BaseViewModel
import java.util.*
import java.util.logging.Logger
import javax.inject.Inject


class CreateAlarmViewModel @Inject constructor(
    private val repository: CreateAlarmRepository,
    private val alarmService: AlarmServiceCreate
) : BaseViewModel<CreateAlarmViewState>() {

    private val log = Logger.getLogger(CreateAlarmViewModel::class.java.name)

    fun createAlarm(alarm: AlarmRoom) {
        log.viewModel("createAlarm")

        compositeDisposable.add(repository.saveAlarm(alarm).subscribe({
            log.viewModel("subscribe")
            val currentAlarm = Alarm(
                name = alarm.name,
                date = Date(alarm.date).toMyFormat(),
                changeLongDate = alarm.date,
                repeatStatus = ConstRepeatStatus.mapToString(alarm.repeatStatus),
                requestCode = alarm.requestCode
            )
            when (alarm.repeatStatus) {
                ConstRepeatStatus.REPEAT_NO_I -> {
                    log.viewModel(alarm.name)
                    alarmService.saveOneAlarm(currentAlarm)
                }
            }
            mutableLiveData.postValue(CreateAlarmViewState.AlarmCreated)
        }, {
            it.printStackTrace()
        }))
    }
}