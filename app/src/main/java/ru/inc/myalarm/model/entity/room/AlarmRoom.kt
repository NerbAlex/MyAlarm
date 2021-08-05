package ru.inc.myalarm.model.entity.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alarm_table")
class AlarmRoom(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val date: Long,
    val repeatStatus: Int
)