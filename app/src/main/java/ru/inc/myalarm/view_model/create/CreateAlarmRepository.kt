package ru.inc.myalarm.view_model.create

import io.reactivex.rxjava3.core.Completable
import ru.inc.myalarm.model.entity.room.AlarmRoom

interface CreateAlarmRepository {
    fun saveAlarm(alarm: AlarmRoom) : Completable
}