package ru.inc.myalarm.model.data.cache

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.inc.myalarm.extensions.toMyFormat
import ru.inc.myalarm.model.database.DataBase
import ru.inc.myalarm.model.entity.ConstRepeatStatus
import ru.inc.myalarm.model.entity.room.AlarmRoom
import ru.inc.myalarm.model.entity.ui.Alarm
import ru.inc.myalarm.model.repositories.AlarmLocalDataSource
import java.util.*


class AlarmCache(private val db: DataBase) : AlarmLocalDataSource {

    override fun getAlarmList(): Single<List<Alarm>> = Single.fromCallable {
        db.alarmDao().getAllAlarm().map { localAlarm ->
            Alarm(
                name = localAlarm.name,
                id = localAlarm.id.toInt(),
                changeLongDate = localAlarm.date,
                date = Date(localAlarm.date).toMyFormat(),
                repeatStatus = mapRepeatStatus(localAlarm.repeatStatus),
                requestCode = localAlarm.requestCode
            )
        }
    }.subscribeOn(Schedulers.io())

    override fun saveAlarm(alarm: AlarmRoom) = db.alarmDao().addAlarm(alarm).subscribeOn(Schedulers.io())

    override fun deleteAlarm(alarm: Alarm) = db.alarmDao().deleteAlarm(
        AlarmRoom(
            id = alarm.id.toLong(),
            name = alarm.name,
            date = alarm.changeLongDate,
            repeatStatus = ConstRepeatStatus.mapToInt(alarm.repeatStatus),
            requestCode = alarm.requestCode
        )
    ).subscribeOn(Schedulers.io())

    private fun mapRepeatStatus(repeatStatus: Int): String = ConstRepeatStatus.mapToString(repeatStatus)
}