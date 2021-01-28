package com.kotlinproject.notes.mvp.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.kotlinproject.notes.NotesApplication
import com.kotlinproject.notes.bus.NoteDeleteAction
import com.kotlinproject.notes.bus.NoteEditAction
import com.kotlinproject.notes.mvp.model.Note
import com.kotlinproject.notes.mvp.model.NoteDao
import com.kotlinproject.notes.mvp.views.NoteView
import org.greenrobot.eventbus.EventBus
import java.util.*
import javax.inject.Inject

@InjectViewState
class NotePresenter(val noteId: Long) : MvpPresenter<NoteView>() {

    @Inject
    lateinit var noteDao: NoteDao
    private lateinit var note: Note

    init {
        NotesApplication.graph.inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        note = noteDao.getNoteById(noteId)!!
        viewState.showNote(note)
    }

    fun saveNote(title: String, text: String, date: Date) {
        note.title = title
        note.text = text
        note.changedAt = Date()
        note.forDate = date
        noteDao.saveNote(note)
        EventBus.getDefault().post(NoteEditAction(note.id))
        viewState.onNoteSaved()
    }

    fun deleteNote() {
        //after deletion note id will be 0,
        // so we should save one before delete operation
        val noteId = note.id
        noteDao.deleteNote(note)
        EventBus.getDefault().post(NoteDeleteAction(noteId))
        viewState.onNoteDeleted()
    }

    fun showNoteDeleteDialog() {
        viewState.showNoteDeleteDialog()
    }

    fun hideNoteDeleteDialog() {
        viewState.hideNoteDeleteDialog()
    }

    fun showNoteInfoDialog() {
        viewState.showNoteInfoDialog(note.getInfo())
    }

    fun hideNoteInfoDialog() {
        viewState.hideNoteInfoDialog()
    }

}
