package com.kotlinproject.notes.di

import dagger.Module
import dagger.Provides
import com.kotlinproject.notes.mvp.model.NoteDao
import javax.inject.Singleton

@Module
class NoteDaoModule {

    @Provides
    @Singleton
    fun provideNoteDao(): NoteDao = NoteDao()

}