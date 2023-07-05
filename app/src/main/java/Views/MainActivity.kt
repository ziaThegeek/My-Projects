package Views

import Models.Employee
import ViewModels.EmployeeViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.customapplication.R

import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var employeeViewModel: EmployeeViewModel
    lateinit var adapter: EmployeeAdapter
    lateinit var fab: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        adapter = EmployeeAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        employeeViewModel =
            ViewModelProvider(this)[EmployeeViewModel::class.java]

        employeeViewModel.allEmployees.observe(
            this,
            Observer { employees -> employees?.let { adapter.setEmployees(it) } })

        fab = findViewById(R.id.add_employee_fab)
        fab.setOnClickListener {
            val dialogView = LayoutInflater.from(this).inflate(R.layout.add_employee_dialog, null)
            val builder = AlertDialog.Builder(this)
                .setView(dialogView)
                .setTitle("Add Employee")
                .setCancelable(true)
            val alertDialog = builder.show()
            val name = dialogView.findViewById<EditText>(R.id.emplName)
            val salary = dialogView.findViewById<EditText>(R.id.emplSalry)
            val dapt = dialogView.findViewById<EditText>(R.id.emplDapt)
            val add_new_empl = dialogView.findViewById<Button>(R.id.addEmpl)

            add_new_empl.setOnClickListener {
                val employee = Employee(
                    0,
                    name.text.toString(),
                    salary.text.toString().toDouble(),
                    dapt.text.toString()
                )
                employeeViewModel.insertEmployee(employee)
                alertDialog.dismiss()
            }


        }

    }
}