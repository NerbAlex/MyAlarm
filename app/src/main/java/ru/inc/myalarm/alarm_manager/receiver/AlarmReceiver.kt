package ru.inc.myalarm.alarm_manager.receiver

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import ru.inc.myalarm.R
import ru.inc.myalarm.alarm_manager.AlarmConstants
import ru.inc.myalarm.model.entity.ui.Alarm

class AlarmReceiver : BroadcastReceiver() {

    companion object {
        const val CHANNEL_ID = "some_channel_idididi777"
        private const val NOTIFICATION_ID = 37
    }

    override fun onReceive(context: Context, intent: Intent) {
        val alarm = intent.getParcelableExtra<Alarm>(AlarmConstants.EXTRA_ALARM_ENTITY)
        when(intent.action) {
            AlarmConstants.ACTION_SET_ONE -> { showNotification(context, alarm) }
        }
    }

    private fun showNotification(context: Context, alarm: Alarm?) {
        val notificationBuilder =
            NotificationCompat.Builder(context, CHANNEL_ID).apply {
                setSmallIcon(R.drawable.ic_launcher_background)
                setContentTitle("Уведомление")
                setContentText(alarm?.name)
                priority = NotificationCompat.PRIORITY_DEFAULT
            }

        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(notificationManager)
        }
        notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build())
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(notificationManager: NotificationManager) {
        val name = "Channel name"
        val descriptionText = "Channel description"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
            description = descriptionText
        }
        notificationManager.createNotificationChannel(channel)
    }
}