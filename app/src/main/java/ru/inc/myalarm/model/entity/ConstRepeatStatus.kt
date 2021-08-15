package ru.inc.myalarm.model.entity

object ConstRepeatStatus {
    const val REPEAT_NO_I = 0
    const val REPEAT_ONE_DAY_I = 1
    const val REPEAT_ONE_WEAK_I = 2
    const val REPEAT_FIVE_MINUTES_I = 3
    const val REPEAT_30_MINUTES_I = 4
    const val REPEAT_3_HOUR_I = 5

    const val REPEAT_NO_S = "нет"
    const val REPEAT_ONE_DAY_S = "1 день"
    const val REPEAT_ONE_WEAK_S = "1 неделю"
    const val REPEAT_FIVE_MINUTES_S = "5 минут"
    const val REPEAT_30_MINUTES_S = "30 минут"
    const val REPEAT_3_HOUR_S = "3 часа"

    fun mapToString(repeatStatus: Int): String = when (repeatStatus) {
        REPEAT_NO_I -> REPEAT_NO_S

        REPEAT_30_MINUTES_I -> REPEAT_30_MINUTES_S

        REPEAT_ONE_DAY_I -> REPEAT_ONE_DAY_S

        REPEAT_ONE_WEAK_I -> REPEAT_ONE_WEAK_S

        REPEAT_FIVE_MINUTES_I -> REPEAT_FIVE_MINUTES_S

        REPEAT_3_HOUR_I -> REPEAT_3_HOUR_S
        else -> {
            throw IllegalArgumentException("unknown status repeat")
        }
    }

    fun mapToInt(repeatStatus: String): Int = when (repeatStatus) {
        REPEAT_NO_S -> REPEAT_NO_I

        REPEAT_30_MINUTES_S -> REPEAT_30_MINUTES_I

        REPEAT_ONE_DAY_S -> REPEAT_ONE_DAY_I

        REPEAT_ONE_WEAK_S -> REPEAT_ONE_WEAK_I

        REPEAT_FIVE_MINUTES_S -> REPEAT_FIVE_MINUTES_I

        REPEAT_3_HOUR_S -> REPEAT_3_HOUR_I
        else -> {
            throw IllegalArgumentException("unknown status repeat")
        }
    }
}