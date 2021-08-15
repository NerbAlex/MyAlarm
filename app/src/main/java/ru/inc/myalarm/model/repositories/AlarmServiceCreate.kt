package ru.inc.myalarm.model.repositories

import ru.inc.myalarm.model.entity.ui.Alarm

interface AlarmServiceCreate {

    fun saveOneAlarm(alarm: Alarm)
    fun saveRepeatAlarm(time: Long)
}