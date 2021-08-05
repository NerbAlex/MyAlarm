package ru.inc.myalarm.view_model.main

import androidx.lifecycle.LiveData
import ru.inc.myalarm.view_model.AppState
import ru.inc.myalarm.view_model.BaseViewModel

class MainViewModel() : BaseViewModel<AppState.MainViewState>() {

    override fun getData(): LiveData<AppState.MainViewState> {
        return super.getData()
    }


}