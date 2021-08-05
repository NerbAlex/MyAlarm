package ru.inc.myalarm.model.database

import androidx.room.*
import io.reactivex.rxjava3.core.Completable
import ru.inc.myalarm.model.entity.Alarm

@Dao
interface AlarmDao {

    @Insert(entity = Alarm::class, onConflict = OnConflictStrategy.REPLACE)
    fun addAlarm(alarm: Alarm): Completable

    @Delete(entity = Alarm::class)
    fun deleteAlarm(alarm: Alarm)

    @Delete(entity = Alarm::class)
    fun deleteAllAlarm(alarmList: List<Alarm>)

    @Query("SELECT * FROM alarm_table")
    fun getAllAlarm(): List<Alarm>
}