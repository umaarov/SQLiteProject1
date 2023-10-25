package uz.umarov.sqliteproject1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.umarov.sqliteproject1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val dbHelper by lazy { MyDbHelper(this) } // Initialize the database helper lazily

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val username = binding.username.text.toString()
            val password = binding.password.text.toString()

            dbHelper.insertUser(username, password)
            dbHelper.readUser(username, password)
        }
    }
}
