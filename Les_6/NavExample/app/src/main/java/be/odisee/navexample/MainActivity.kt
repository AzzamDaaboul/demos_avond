package be.odisee.navexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import be.odisee.navexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        binding.button1.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        binding.button2.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.type="text/plain"

            intent.putExtra(Intent.EXTRA_EMAIL, "matthias.druwe@odisee.be")
            intent.putExtra(Intent.EXTRA_TEXT,"Dit is een bericht vanuit mijn nieuwe app")
            if(intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            }
        }
    }


}