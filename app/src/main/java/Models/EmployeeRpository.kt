package Models

import androidx.lifecycle.LiveData

class EmployeeRpository(private  val employeeDao: EmployeeDao) {
    val allEmployees:LiveData<List<Employee>> = employeeDao.getEmployess()
   suspend fun insert(employee: Employee){
        employeeDao.insert(employee)
    }
    suspend fun delete(employee: Employee){
        employeeDao.delete(employee)
    }
}