package be.odisee.bmi

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import be.odisee.bmi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.calculateButton.setOnClickListener {
            val length = binding.lengthEditText.text.toString().toDoubleOrNull()
            val weight = binding.weightEditText.text.toString().toDoubleOrNull()

            if (length == null || weight == null) {
                Toast.makeText(this, "Gelieve correcte nummers in te geven", Toast.LENGTH_LONG)
                    .show()
            } else {
                val bmi = weight / (length * length)
                binding.bmi = bmi
//                val text = getString(R.string.bmi_result, bmi.toString())
//                binding.result.text = text
            }
        }
    }
}