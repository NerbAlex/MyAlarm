package ru.inc.myalarm.alarm_manager.service

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import ru.inc.myalarm.alarm_manager.AlarmConstants
import ru.inc.myalarm.alarm_manager.receiver.AlarmReceiver
import ru.inc.myalarm.model.entity.ui.Alarm
import ru.inc.myalarm.model.repositories.AlarmServiceChange
import ru.inc.myalarm.model.repositories.AlarmServiceCreate

class AlarmService(private val context: Context) : AlarmServiceChange,
    AlarmServiceCreate {

    private val alarmManager = context.applicationContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager

    override fun deleteAlarm(time: Long) {

    }

    override fun saveOneAlarm(alarm: Alarm) {
        saveOne(
            alarm.changeLongDate,
            getPendingIntent(
                getIntent().apply {
                    action = AlarmConstants.ACTION_SET_ONE
                    putExtra(AlarmConstants.EXTRA_ALARM_ENTITY, alarm)
                }, alarm.requestCode)
        )
    }

    private fun saveOne(time: Long, pendingIntent: PendingIntent) {
        alarmManager.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                it.setExactAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP,
                    time,
                    pendingIntent
                )
            } else {
                it.setExact(
                    AlarmManager.RTC_WAKEUP,
                    time,
                    pendingIntent
                )
            }
        }
    }

    override fun saveRepeatAlarm(time: Long) {

    }

    private fun getIntent() = Intent(context, AlarmReceiver::class.java)

    private fun getPendingIntent(intent: Intent, requestCode: Int) =
        PendingIntent.getBroadcast(
            context,
            requestCode,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
}