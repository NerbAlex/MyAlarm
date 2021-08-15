package ru.inc.myalarm.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.inc.myalarm.model.entity.room.AlarmRoom
import ru.inc.myalarm.model.entity.ui.Alarm

@Database(entities = [AlarmRoom::class], version = 1)
abstract class DataBase: RoomDatabase() {

    companion object{
        const val NAME = "database_my_alarm_4"
    }

    abstract fun alarmDao(): AlarmDao

}