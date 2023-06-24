package Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Employees")
data class Employee(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id:Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name="salary") val salary:Double,
    @ColumnInfo(name = "daprtment") val dapartment:String

)
