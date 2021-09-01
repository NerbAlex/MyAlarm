package ru.inc.myalarm.model.database

import androidx.room.*
import io.reactivex.rxjava3.core.Completable
import ru.inc.myalarm.model.entity.room.AlarmRoom

@Dao
interface AlarmDao {

    @Insert(entity = AlarmRoom::class, onConflict = OnConflictStrategy.REPLACE)
    fun addAlarm(alarm: AlarmRoom): Completable

    @Delete(entity = AlarmRoom::class)
    fun deleteAlarm(alarm: AlarmRoom): Completable

    @Delete(entity = AlarmRoom::class)
    fun deleteAllAlarm(alarmList: List<AlarmRoom>)

    @Query("SELECT * FROM alarm_table")
    fun getAllAlarm(): List<AlarmRoom>
}