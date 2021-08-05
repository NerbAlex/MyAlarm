package ru.inc.myalarm.view_model.main

import io.reactivex.rxjava3.core.Single
import ru.inc.myalarm.model.entity.ui.Alarm

interface MainAlarmRepository {
    fun getData(): Single<List<Alarm>>
}