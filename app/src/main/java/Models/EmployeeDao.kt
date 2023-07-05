package Models

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EmployeeDao {
    @Query("SELECT * FROM EMPLOYEES")
    fun getEmployess(): LiveData<List<Employee>>

    @Insert
    fun insert(employee: Employee)

    @Delete
    fun delete(employee: Employee)

}