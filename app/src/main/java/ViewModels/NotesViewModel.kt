package ViewModels

import Models.Note
import Models.NotesDatabase
import Models.NotesRepository
import ModelssDa.NoteDao
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application) : AndroidViewModel(application) {
    private val notesRepository: NotesRepository
    val allNotes: LiveData<List<Note>>

    init {
        val notesDao: NoteDao = NotesDatabase.getDatabase(application).notesDao()
        notesRepository = NotesRepository(notesDao)
        allNotes = notesRepository.allNotes
    }

    fun notes(): LiveData<List<Note>> {
        return notesRepository.allNotes
    }

    fun insertNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) { notesRepository.insert(note) }

    }

    fun deleteNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            notesRepository.delete(note)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) { notesRepository.update(note) }
    }
}