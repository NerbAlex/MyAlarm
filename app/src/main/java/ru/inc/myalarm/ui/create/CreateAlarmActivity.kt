package ru.inc.myalarm.ui.create

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.inc.myalarm.R
import ru.inc.myalarm.databinding.ActivityCreateAlarmBinding
import ru.inc.myalarm.model.entity.room.AlarmRoom
import ru.inc.myalarm.model.entity.ui.Alarm
import ru.inc.myalarm.view_model.AppState
import ru.inc.myalarm.view_model.create.CreateAlarmViewModel
import ru.inc.myalarm.view_model.main.MainViewModel
import java.util.*
import java.util.concurrent.TimeUnit

class CreateAlarmActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, CreateAlarmActivity::class.java)
    }

    private lateinit var ui: ActivityCreateAlarmBinding
    private lateinit var viewModel: CreateAlarmViewModel
    private val alarm by lazy { createAlarm() }
    private var date: Long? = null

    private fun createAlarm(): AlarmRoom {
        return AlarmRoom(
            name = ui.editTxtTitleAlarm.text.toString(),
            repeatStatus = ui.ratingBar.rating.toInt(),
            date = date ?: Date().time
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityCreateAlarmBinding.inflate(layoutInflater)
        setContentView(ui.root)

        initViewModel()
        initListeners()
    }

    private fun initListeners() {
        ui.btnCreateAlarm.setOnClickListener { onBackPressed() }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(CreateAlarmViewModel::class.java)
        viewModel.getData().observe(this) { renderData(it) }
        viewModel.startViewModel()
    }

    private fun renderData(state: AppState.CreateAlarmViewState) {
    }

    override fun onBackPressed() {
        with(ui) {
            if (date != null && editTxtTitleAlarm.text.isNotEmpty()) {
                viewModel.createAlarm(alarm)
            } else {
                Toast
                    .makeText(this@CreateAlarmActivity, getString(R.string.not_save_task), Toast.LENGTH_LONG)
                    .show()
                super.onBackPressed()
            }
        }
    }
}