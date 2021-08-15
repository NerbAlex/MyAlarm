package ru.inc.myalarm.model.entity

object ConstRepeatStatus {
        const val REPEAT_NO = 0
        const val REPEAT_ONE_DAY = 1
        const val REPEAT_ONE_WEAK = 2
        const val REPEAT_ONE_MINUTES = 3
        const val REPEAT_30_MINUTES = 4
        const val REPEAT_3_HOUR = 5

    fun checkRepeat(repeatStatus: Int): String = when (repeatStatus) {
        REPEAT_NO -> {
            "нет"
        }
        REPEAT_30_MINUTES -> {
            "30 минут"
        }
        REPEAT_ONE_DAY -> {
            "1 день"
        }
        REPEAT_ONE_WEAK -> {
            "1 неделю"
        }
        REPEAT_ONE_MINUTES -> {
            "1 минуту"
        }
        REPEAT_3_HOUR -> {
            "3 часа"
        }
        else -> {
            throw IllegalArgumentException("unknown status repeat")
        }
    }
}