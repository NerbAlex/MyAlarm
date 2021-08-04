package ru.inc.myalarm.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.inc.myalarm.databinding.ActivityCreateAlarmBinding

class CreateAlarmActivity : AppCompatActivity() {

    private lateinit var ui: ActivityCreateAlarmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityCreateAlarmBinding.inflate(layoutInflater)
        setContentView(ui.root)
    }
}