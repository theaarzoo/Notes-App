package com.kotlinproject.notes.mvp.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.kotlinproject.notes.mvp.model.Note

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface MainView : MvpView {

    fun onNotesLoaded(notes: List<Note>)

    fun updateView()

    fun onSearchResult(notes: List<Note>)

    fun onAllNotesDeleted()

    fun onNoteDeleted()

    fun showNoteInfoDialog(noteInfo: String)

    fun hideNoteInfoDialog()

    fun showNoteDeleteDialog(notePosition: Int)

    fun hideNoteDeleteDialog()

    fun showNoteContextDialog(notePosition: Int)

    fun hideNoteContextDialog()

    fun openNoteScreen(noteId: Long)

}