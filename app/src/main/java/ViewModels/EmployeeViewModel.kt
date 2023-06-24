package ViewModels

import Models.Employee
import Models.EmployeeRpository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmployeeViewModel(private val employeeRpository: EmployeeRpository):ViewModel() {
    fun employees():LiveData<List<Employee>>{
        return employeeRpository.allEmployees
    }
     fun insertEmployee(employee: Employee){
         viewModelScope.launch(Dispatchers.IO) {
             employeeRpository.insert(employee)
         }
    }
    fun deleteEmployee(employee: Employee){
        viewModelScope.launch(Dispatchers.IO) {
            employeeRpository.delete(employee)
        }
    }

}