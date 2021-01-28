package com.kotlinproject.notes

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.kotlinproject.notes.di.AppComponent
import com.kotlinproject.notes.di.DaggerAppComponent
import com.kotlinproject.notes.di.NoteDaoModule
import com.kotlinproject.notes.mvp.model.AppDatabase
import com.kotlinproject.notes.mvp.model.Note
import com.reactiveandroid.ReActiveAndroid
import com.reactiveandroid.ReActiveConfig
import com.reactiveandroid.internal.database.DatabaseConfig

class NotesApplication : Application() {

    companion object {
        lateinit var graph: AppComponent
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()

        context = this
        graph = DaggerAppComponent.builder().noteDaoModule(NoteDaoModule()).build()

        val appDatabaseConfig = DatabaseConfig.Builder(AppDatabase::class.java)
                .addModelClasses(Note::class.java)
                .build()

        ReActiveAndroid.init(ReActiveConfig.Builder(this)
                .addDatabaseConfigs(appDatabaseConfig)
                .build())
    }

}
