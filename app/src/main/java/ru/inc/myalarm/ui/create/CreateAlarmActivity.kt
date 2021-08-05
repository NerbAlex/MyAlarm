package ru.inc.myalarm.ui.create

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.inc.myalarm.databinding.ActivityCreateAlarmBinding
import ru.inc.myalarm.view_model.AppState
import ru.inc.myalarm.view_model.create.CreateAlarmViewModel

class CreateAlarmActivity : AppCompatActivity() {

    private lateinit var ui: ActivityCreateAlarmBinding
    private lateinit var viewModel: CreateAlarmViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityCreateAlarmBinding.inflate(layoutInflater)
        setContentView(ui.root)

        initViewModel()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(CreateAlarmViewModel::class.java)
        viewModel.getData().observe(this) { renderData(it) }
    }

    private fun renderData(state: AppState.CreateAlarmViewState) {

    }
}