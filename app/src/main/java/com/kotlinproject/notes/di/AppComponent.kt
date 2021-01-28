package com.kotlinproject.notes.di

import dagger.Component
import com.kotlinproject.notes.mvp.presenters.MainPresenter
import com.kotlinproject.notes.mvp.presenters.NotePresenter
import javax.inject.Singleton

@Singleton
@Component(modules = [NoteDaoModule::class])
interface AppComponent {
    fun inject(mainPresenter: MainPresenter)

    fun inject(notePresenter: NotePresenter)
}