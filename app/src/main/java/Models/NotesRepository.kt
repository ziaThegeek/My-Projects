package Models

import ModelssDa.NoteDao
import androidx.lifecycle.LiveData

class NotesRepository(private val notesDao: NoteDao) {
    val allNotes: LiveData<List<Note>> = notesDao.getNotes()
    suspend fun insert(note: Note) {
        notesDao.insert(note)
    }

    suspend fun delete(note: Note) {
        notesDao.delete(note)
    }

    suspend fun update(note: Note) {
        notesDao.upddate(note)
    }

}