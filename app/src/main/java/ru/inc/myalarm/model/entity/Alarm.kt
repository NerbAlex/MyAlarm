package ru.inc.myalarm.model.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Alarm(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val date: Long,
    val repeatStatus: Int
) : Parcelable
