package ru.inc.myalarm.extensions

import java.util.logging.Logger

/**
 * Контролируем отображение логов
 *
 * [lifecycle] - жизненный цикл Активности, фрагмента, вью, др.
 * [rxJava] - логирование внутри операторов RxJava, подписчиках
 * [room] - классы связанные с Room
 * [viewModel], [repository] и т.п. - Внутренние функции работы классов ViewModel, Repository не связанные с логикой
 * других расширений логера из текущего файла LoggerExtensions.kt
 */

private const val isLifecycle = true
private const val isRxJava = true
private const val isRoom = true
private const val isViewModel = true
private const val isRepository = true

fun Logger.lifecycle(log: String) {
    if (isLifecycle) {
        this.info("MyAlarm_: $log")
    }
}

fun Logger.rxJava(log: String) {
    if (isRxJava) {
        this.info("MyAlarm_: $log")
    }
}

fun Logger.room(log: String) {
    if (isRoom) {
        this.info("MyAlarm_: $log")
    }
}

fun Logger.viewModel(log: String) {
    if (isViewModel) {
        this.info("MyAlarm_: $log")
    }
}

fun Logger.repository(log: String) {
    if (isRepository) {
        this.info("MyAlarm_: $log")
    }
}