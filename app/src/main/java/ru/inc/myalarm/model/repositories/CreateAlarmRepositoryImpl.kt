package ru.inc.myalarm.model.repositories

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.inc.myalarm.extensions.room
import ru.inc.myalarm.model.entity.room.AlarmRoom
import ru.inc.myalarm.view_model.create.CreateAlarmRepository
import ru.inc.myalarm.view_model.create.CreateAlarmViewModel
import java.util.logging.Logger

class CreateAlarmRepositoryImpl(private val localDataSource: AlarmLocalDataSource): CreateAlarmRepository {

    private val log = Logger.getLogger(CreateAlarmRepositoryImpl::class.java.name)

    override fun saveAlarm(alarm: AlarmRoom): Completable {
        log.room("saveAlarm")
        return localDataSource.saveAlarm(alarm).subscribeOn(Schedulers.io())
    }
}