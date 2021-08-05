package ru.inc.myalarm.extensions

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

const val simplePattern = "dd MMM yy"

@SuppressLint("SimpleDateFormat")
val dateFormatter = SimpleDateFormat(simplePattern)

fun Date.toMyFormat(): String = dateFormatter.format(this)

@SuppressLint("SimpleDateFormat")
fun String.toDateFormat(): Date =
    SimpleDateFormat(simplePattern).parse(this) ?: throw NullPointerException("check toDateFormat Extension")


