package ru.inc.myalarm.alarm_manager.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import ru.inc.myalarm.alarm_manager.AlarmConstants
import ru.inc.myalarm.model.entity.ui.Alarm

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val alarm = intent.getParcelableExtra<Alarm>(AlarmConstants.EXTRA_ALARM_ENTITY)
        when(intent.action) {
            AlarmConstants.ACTION_SET_ONE -> { createNotification() }
        }
    }

    private fun createNotification() {

    }
}