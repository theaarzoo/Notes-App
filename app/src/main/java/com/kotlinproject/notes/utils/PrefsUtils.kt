@file:JvmName("PrefsUtils")

package com.kotlinproject.notes.utils

import android.content.Context
import com.kotlinproject.notes.NotesApplication

private val prefs by lazy {
    NotesApplication.context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
}

fun getNotesSortMethodName(defaultValue: String): String = prefs.getString("sort_method", defaultValue)

fun setNotesSortMethod(sortMethod: String) {
    prefs.edit().putString("sort_method", sortMethod).apply()
}
