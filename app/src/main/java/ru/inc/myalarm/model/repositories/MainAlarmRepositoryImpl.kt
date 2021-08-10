package ru.inc.myalarm.model.repositories

import io.reactivex.rxjava3.core.Single
import ru.inc.myalarm.model.entity.ui.Alarm
import ru.inc.myalarm.view_model.main.MainAlarmRepository
import java.util.*

class MainAlarmRepositoryImpl(private val localDataSource: AlarmLocalDataSource): MainAlarmRepository {

    override fun getData(): Single<List<Alarm>> {
//        localDataSource.getAlarmList()
        return Single.just(listOf(Alarm(
            id = 1,
            name = "some",
            date = "10 января 2021. 13:00",
            repeatStatus = "1 день",
            changeLongDate = Date().time
        )))
    }

}