package Views

import ViewModels.EmployeeViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.customapplication.R
import com.example.customapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var employeeViewModel: EmployeeViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)


    }
}