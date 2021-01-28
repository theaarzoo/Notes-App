package com.kotlinproject.notes.mvp.views

import com.arellomobile.mvp.MvpView
import com.kotlinproject.notes.mvp.model.Note

interface NoteView : MvpView {

    fun showNote(note: Note)

    fun onNoteSaved()

    fun onNoteDeleted()

    fun showNoteInfoDialog(noteInfo: String)

    fun hideNoteInfoDialog()

    fun showNoteDeleteDialog()

    fun hideNoteDeleteDialog()

}
