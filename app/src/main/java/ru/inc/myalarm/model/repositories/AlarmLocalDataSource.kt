package ru.inc.myalarm.model.repositories

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.inc.myalarm.model.entity.room.AlarmRoom
import ru.inc.myalarm.model.entity.ui.Alarm

interface AlarmLocalDataSource {
    fun getAlarmList(): Single<List<Alarm>>
    fun saveAlarm(alarm: AlarmRoom): Completable
    fun deleteAlarm(alarm: Alarm): Completable
}