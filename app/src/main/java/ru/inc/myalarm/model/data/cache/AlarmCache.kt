package ru.inc.myalarm.model.data.cache

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.inc.myalarm.extensions.toMyFormat
import ru.inc.myalarm.model.database.DataBase
import ru.inc.myalarm.model.entity.ConstRepeatStatus
import ru.inc.myalarm.model.entity.ui.Alarm
import ru.inc.myalarm.model.repositories.AlarmLocalDataSource
import java.lang.IllegalArgumentException
import java.util.*


class AlarmCache(val db: DataBase) : AlarmLocalDataSource {

    //TODO пока просто перегнать лонг дату в стрингу, не использовать TypeConverter, лонг тоже будет нужен для
    // AlarmManager, так же мапить repeatStatus Int в String, не использовать TypeConverter, т.к. может быть другой Int в сущности


    override fun getAlarmList(): Single<List<Alarm>> = Single.fromCallable {
        db.alarmDao().getAllAlarm().map { localAlarm ->
            Alarm(
                name = localAlarm.name,
                id = localAlarm.id.toInt(),
                changeLongDate = localAlarm.date,
                date = Date(localAlarm.date).toMyFormat(),
                repeatStatus = mapRepeatStatus(localAlarm.repeatStatus)
            )
        }
    }.subscribeOn(Schedulers.io())

    private fun mapRepeatStatus(repeatStatus: Int): String = when (repeatStatus) {
        ConstRepeatStatus.REPEAT_NO -> {
            "нет"
        }
        ConstRepeatStatus.REPEAT_30_MINUTES -> {
            "30 минут"
        }
        ConstRepeatStatus.REPEAT_ONE_DAY -> {
            "1 день"
        }
        ConstRepeatStatus.REPEAT_ONE_WEAK -> {
            "1 неделю"
        }
        ConstRepeatStatus.REPEAT_ONE_MINUTES -> {
            "1 минуту"
        }
        ConstRepeatStatus.REPEAT_3_HOUR -> {
            "3 часа"
        }
        else -> {
            throw IllegalArgumentException("unknown status repeat")
        }
    }


}