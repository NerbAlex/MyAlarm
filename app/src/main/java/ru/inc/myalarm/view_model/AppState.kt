package ru.inc.myalarm.view_model

import ru.inc.myalarm.model.entity.Alarm

sealed class AppState {

    sealed class MainViewState: AppState() {
        data class Success(val list: List<Alarm>): MainViewState()
    }

    sealed class CreateAlarmViewState: AppState() {

    }
}
