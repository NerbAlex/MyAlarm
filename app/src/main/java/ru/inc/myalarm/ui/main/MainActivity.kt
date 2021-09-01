package ru.inc.myalarm.ui.main

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.inc.myalarm.MyApp
import ru.inc.myalarm.R
import ru.inc.myalarm.databinding.ActivityMainBinding
import ru.inc.myalarm.di.factory.ConstFactory
import ru.inc.myalarm.model.entity.ui.Alarm
import ru.inc.myalarm.ui.create.CreateAlarmActivity
import ru.inc.myalarm.view_model.main.MainViewModel
import ru.inc.myalarm.view_model.main.MainViewState
import java.util.logging.Logger
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity() {

    @Inject
    @Named(ConstFactory.MAIN)
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: MainViewModel by lazy { initViewModel() }

    private lateinit var ui: ActivityMainBinding
    private lateinit var adapter: MainAdapter
    private var currentAlarm: Alarm? = null

    private val log = Logger.getLogger(MainActivity::class.java.name)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)

        initRecyclerView()
        initListeners()
        observeData()
    }

    private fun observeData() {
        MyApp.instance.appComponent.inject(this)
        viewModel.getData().observe(this) { renderData(it) }
    }

    private fun initListeners() {
        ui.btnCreateAlert.setOnClickListener {
            startActivity(Intent(this, CreateAlarmActivity::class.java))
        }

        ui.btnDeleteCurrent.setOnClickListener {
            viewModel.deleteAlarm(currentAlarm)
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.startViewModel()
    }

    @SuppressLint("SetTextI18n")
    private fun initRecyclerView() {
        adapter = MainAdapter()
        ui.recycler.adapter = adapter

        adapter.lmdClickListener = { alarm ->
            currentAlarm = alarm

            with(ui) {
                txtAlertDate.text = alarm.date
                txtAlertName.text = alarm.name
                txtRepeatAlert.text = "Повтор: ${alarm.repeatStatus}"
            }
        }
    }

    private fun initViewModel() = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

    private fun renderData(state: MainViewState) {
        when (state) {
            is MainViewState.Success -> {
                adapter.list = state.list
            }

            is MainViewState.FirstStart -> {
                Toast.makeText(this, getString(R.string.first_start_state), Toast.LENGTH_LONG).show()
            }

            is MainViewState.Error -> {
                Toast.makeText(this, getString(R.string.error_state), Toast.LENGTH_LONG).show()
            }
        }
    }
}