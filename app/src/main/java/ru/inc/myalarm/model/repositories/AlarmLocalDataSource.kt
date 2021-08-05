package ru.inc.myalarm.model.repositories

import io.reactivex.rxjava3.core.Single
import ru.inc.myalarm.model.entity.ui.Alarm

interface AlarmLocalDataSource {
    fun getAlarmList(): Single<List<Alarm>>
}