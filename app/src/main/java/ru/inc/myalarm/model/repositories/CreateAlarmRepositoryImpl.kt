package ru.inc.myalarm.model.repositories

import ru.inc.myalarm.model.entity.room.AlarmRoom
import ru.inc.myalarm.view_model.create.CreateAlarmRepository

class CreateAlarmRepositoryImpl(private val localDataSource: AlarmLocalDataSource): CreateAlarmRepository {

    override fun saveAlarm(alarm: AlarmRoom) = localDataSource.saveAlarm(alarm)
}