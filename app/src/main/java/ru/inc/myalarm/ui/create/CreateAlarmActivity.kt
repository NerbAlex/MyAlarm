package ru.inc.myalarm.ui.create

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.inc.myalarm.R
import ru.inc.myalarm.databinding.ActivityCreateAlarmBinding
import ru.inc.myalarm.extensions.lifecycle
import ru.inc.myalarm.extensions.viewModel
import ru.inc.myalarm.model.entity.ConstRepeatStatus
import ru.inc.myalarm.model.entity.room.AlarmRoom
import ru.inc.myalarm.view_model.create.CreateAlarmViewModel
import ru.inc.myalarm.view_model.create.CreateAlarmViewState
import ru.inc.myalarm.view_model.main.MainViewModel
import java.util.*
import java.util.logging.Logger
import kotlin.random.Random

class CreateAlarmActivity : AppCompatActivity() {

    private val log = Logger.getLogger(MainViewModel::class.java.name)
    private lateinit var ui: ActivityCreateAlarmBinding
    private lateinit var viewModel: CreateAlarmViewModel
    private val alarm by lazy { createAlarm() }
    private var date: Long? = null

    private fun createAlarm() = with(ui) {
        AlarmRoom(
            name = editTxtTitleAlarm.text.toString(),
            repeatStatus = ratingBar.rating.toInt(),
            date = date ?: Date().time,
            requestCode = Random.nextInt()
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
        ui.btnDateAlarm.setOnClickListener { setAlarm() }
        ui.ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            if (fromUser) {
                ui.txtRepeatAlert.text = ConstRepeatStatus.mapToString(rating.toInt())
            }
        }
    }

    private fun setAlarm() {
        Calendar.getInstance().apply {
            this.set(Calendar.SECOND, 0)
            this.set(Calendar.MILLISECOND, 0)
            DatePickerDialog(
                this@CreateAlarmActivity,
                0,
                { _, year, month, day ->
                    this.set(Calendar.YEAR, year)
                    this.set(Calendar.MONTH, month)
                    this.set(Calendar.DAY_OF_MONTH, day)
                    TimePickerDialog(
                        this@CreateAlarmActivity,
                        0,
                        { _, hour, minute ->
                            this.set(Calendar.HOUR_OF_DAY, hour)
                            this.set(Calendar.MINUTE, minute)
                            date = this.timeInMillis
                        },
                        this.get(Calendar.HOUR_OF_DAY),
                        this.get(Calendar.MINUTE),
                        false
                    ).show()
                },
                this.get(Calendar.YEAR),
                this.get(Calendar.MONTH),
                this.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(CreateAlarmViewModel::class.java)
        viewModel.getData().observe(this) { renderData(it) }
        viewModel.startViewModel()
    }

    private fun renderData(state: CreateAlarmViewState) {
        when (state) {
            is CreateAlarmViewState.AlarmCreated -> {
                log.viewModel("AlarmCreated")
                finish()}


            is CreateAlarmViewState.Error -> {
                Toast.makeText(this, getString(R.string.error_state), Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onBackPressed() {
        log.lifecycle("onBackPressed")

        with(ui) {
            if (date != null && editTxtTitleAlarm.text.isNotEmpty()) {
                viewModel.createAlarm(alarm)
            } else {
                Toast.makeText(this@CreateAlarmActivity, getString(R.string.not_save_task), Toast.LENGTH_LONG)
                    .show()

                super.onBackPressed()
            }
        }
    }
}