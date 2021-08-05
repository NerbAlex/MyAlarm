package ru.inc.myalarm.ui.main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import ru.inc.myalarm.databinding.ActivityMainBinding
import ru.inc.myalarm.model.entity.ConstRepeatStatus
import ru.inc.myalarm.view_model.AppState
import ru.inc.myalarm.view_model.main.MainViewModel
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity() {

    private lateinit var ui: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)

        initRecyclerView()
        initViewModel()
    }

    @SuppressLint("SetTextI18n")
    private fun initRecyclerView() {
        adapter = MainAdapter()
        ui.recycler.adapter = adapter

        adapter.lmdClickListener = { alarm ->
            with(ui) {
                txtAlertDate.text = alarm.date
                txtAlertName.text = alarm.name
                txtRepeatAlert.text = "Повтор: ${alarm.repeatStatus}"
            }
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getData().observe(this) { renderData(it) }
        viewModel.startViewModel()
    }

    private fun renderData(state: AppState.MainViewState) {

    }
}