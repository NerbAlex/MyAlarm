package ru.inc.myalarm.model.data.cache

import ru.inc.myalarm.model.database.DataBase
import ru.inc.myalarm.model.repositories.AlarmLocalDataSource

class AlarmCache(val db: DataBase): AlarmLocalDataSource {
}