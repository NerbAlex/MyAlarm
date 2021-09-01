package ru.inc.myalarm.model.repositories

import io.reactivex.rxjava3.core.Single
import ru.inc.myalarm.model.entity.ui.Alarm
import ru.inc.myalarm.view_model.main.MainAlarmRepository

class MainAlarmRepositoryImpl(private val localDataSource: AlarmLocalDataSource): MainAlarmRepository {

    override fun getData(): Single<List<Alarm>> = localDataSource.getAlarmList()

    override fun deleteAlarm(alarm: Alarm) = localDataSource.deleteAlarm(alarm)
}