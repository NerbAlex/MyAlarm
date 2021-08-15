package ru.inc.myalarm.model.repositories

import ru.inc.myalarm.model.entity.ui.Alarm

interface AlarmServiceChange {

    fun deleteAlarm(alarm: Alarm)
}