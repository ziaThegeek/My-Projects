package Views

import Models.EmployeeDatabase
import Models.Note
import Models.NotesDatabase
import Models.NotesRepository
import ModelssDa.NoteDao
import ViewModels.NotesViewModel
import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.example.customapplication.R
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec
import kotlinx.coroutines.launch


class NotesAdapter(context: Context) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {
    private var notes: List<Note> = emptyList()
    private val notesViewModel: NotesViewModel by lazy {
        ViewModelProvider(context as ViewModelStoreOwner)[NotesViewModel::class.java]
    }

    inner class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val description: TextView = itemView.findViewById(R.id.description)
        val date: TextView = itemView.findViewById(R.id.date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.notes_item_view, parent, false)
        return NotesViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.title.text = notes[position].title
        holder.description.text = notes[position].description
        holder.date.text = notes[position].date
    }

    internal fun setNotes(notes: List<Note>) {
        this.notes = notes
        notifyDataSetChanged()
    }

}