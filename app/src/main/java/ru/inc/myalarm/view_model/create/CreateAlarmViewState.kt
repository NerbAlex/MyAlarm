package ru.inc.myalarm.view_model.create

sealed class CreateAlarmViewState {
    object AlarmCreated: CreateAlarmViewState()
    object Error: CreateAlarmViewState()
}
