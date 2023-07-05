package Views

import Global.Params
import Models.Note
import ViewModels.EmployeeViewModel
import ViewModels.NotesViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.customapplication.R

class NottesActivity : AppCompatActivity() {
    lateinit var notesAdapter: NotesAdapter
    lateinit var notesViewModel: NotesViewModel
    lateinit var newNote: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nottes)
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        newNote = findViewById(R.id.add_note)

        notesAdapter = NotesAdapter(this)
        recyclerView.adapter = notesAdapter
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        notesViewModel = ViewModelProvider(this)[NotesViewModel::class.java]
        notesViewModel.allNotes.observe(this) { notes -> notes?.let { notesAdapter.setNotes(it) } }
        newNote.setOnClickListener {
            val dialogView = LayoutInflater.from(this).inflate(R.layout.new_note_dialog, null)
            val dialogBuilder = AlertDialog.Builder(this)
                .setView(dialogView)
                .setTitle("New Note")
                .setCancelable(true)
            val alertDialog = dialogBuilder.show()
            val title: EditText = dialogView.findViewById(R.id.title)
            val description: EditText = dialogView.findViewById(R.id.description)
            val new_note: Button = dialogView.findViewById(R.id.new_note)
            new_note.setOnClickListener {
                val note = Note(
                    0,
                    title.text.toString(),
                    description.text.toString(),
                    Params.getCurrentDate()
                )
                notesViewModel.insertNote(note)
                alertDialog.dismiss()
            }


        }
    }
}