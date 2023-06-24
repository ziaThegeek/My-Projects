package Models

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.time.chrono.HijrahChronology.INSTANCE

@Database(entities = [Employee::class], version = 1, exportSchema = false)
abstract class EmployeeDatabase:RoomDatabase() {
    abstract fun employeeDao(): EmployeeDao

    companion object {
        private var INSTANCE: EmployeeDatabase? = null
        fun getDatabase(context: Context): EmployeeDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        EmployeeDatabase::class.java,
                        "Employees"
                    )
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}