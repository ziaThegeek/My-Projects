package Views

import Models.Employee
import ViewModels.EmployeeViewModel
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.customapplication.R

class EmployeeAdapter(private val context: Context):RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {
    private var employees:List<Employee> = emptyList()
    private val employeeViewModel:EmployeeViewModel by lazy {
        ViewModelProvider(context as ViewModelStoreOwner).get(EmployeeViewModel::class.java)
    }
    inner class EmployeeViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val employeeNameText:TextView = itemView.findViewById(R.id.name)
        val employeeSalaryText:TextView = itemView.findViewById(R.id.salary)
        val employeeDaptText:TextView = itemView.findViewById(R.id.dapartment)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.employee_item_view,parent,false)
        return EmployeeViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return employees.size
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
       val current=employees[position]
        holder.employeeNameText.text=current.name
        holder.employeeSalaryText.text=current.salary.toString()
        holder.employeeDaptText.text=current.dapartment
    }
    internal fun setEmployees(employees:List<Employee>){
        this.employees=employees
        notifyDataSetChanged()

    }
}