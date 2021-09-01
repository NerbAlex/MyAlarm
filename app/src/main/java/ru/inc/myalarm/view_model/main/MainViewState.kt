package ru.inc.myalarm.view_model.main

import ru.inc.myalarm.model.entity.ui.Alarm


sealed class MainViewState {
    data class Success(val list: List<Alarm>) : MainViewState()
    object Error : MainViewState()
    object FirstStart : MainViewState()
}



