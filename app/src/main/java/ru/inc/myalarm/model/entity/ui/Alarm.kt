package ru.inc.myalarm.model.entity.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Alarm(
    var id: Int = 0,
    val name: String,
    val date: String,
    val repeatStatus: String,
    var changeLongDate: Long
) : Parcelable
