package ru.inc.myalarm.model.entity

interface ConstRepeatStatus {

    companion object{
        const val REPEAT_ONE_DAY = 1
        const val REPEAT_ONE_WEAK = 2
        const val REPEAT_ONE_MINUTES = 3
        const val REPEAT_30_MINUTES = 4
        const val REPEAT_3_HOUR = 5
    }
}