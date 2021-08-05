package ru.inc.myalarm.model.repositories

import ru.inc.myalarm.view_model.create.CreateAlarmRepository

class CreateAlarmRepositoryImpl(val localDataSource: AlarmLocalDataSource): CreateAlarmRepository {
}