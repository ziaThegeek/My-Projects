package ViewModels

import Models.Employee
import Models.EmployeeDao
import Models.EmployeeDatabase
import Models.EmployeeRpository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmployeeViewModel(
    application: Application,
) : AndroidViewModel(application) {

    private val employeeRpository: EmployeeRpository
    val allEmployees: LiveData<List<Employee>>

    init {
        val employeeDao = EmployeeDatabase.getDatabase(application).employeeDao()
        employeeRpository = EmployeeRpository(employeeDao)
        allEmployees = employeeRpository.allEmployees
    }

    fun employees(): LiveData<List<Employee>> {
        return employeeRpository.allEmployees
    }

    fun insertEmployee(employee: Employee) {
        viewModelScope.launch(Dispatchers.IO) {
            employeeRpository.insert(employee)
        }
    }

    fun deleteEmployee(employee: Employee) {
        viewModelScope.launch(Dispatchers.IO) {
            employeeRpository.delete(employee)


        }
    }

}