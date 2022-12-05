package be.odisee.les_4

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var numbersTextView: TextView
    lateinit var starsTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        numbersTextView = findViewById(R.id.numbers)
        starsTextView = findViewById(R.id.stars)

        button.setOnClickListener {
            generateNumbers()
            generateStars()
        }
    }

    private fun generateNumbers() {
        val numbers = mutableListOf<Int>()
        repeat(5) {
            var number = 0
            do {
                number = Random.nextInt(50) + 1
            } while (numbers.contains(number))
            numbers.add(number)
        }

        val numbersString = numbers.sorted().joinToString()
        numbersTextView.text = getString(R.string.numbers_text, numbersString)
    }

    private fun generateStars() {
        val numbers = mutableListOf<Int>()
        repeat(2) {
            var number = 0
            do {
                number = Random.nextInt(12) + 1
            } while (numbers.contains(number))
            numbers.add(number)
        }
        
        val numbersString = numbers.sorted().joinToString()
        starsTextView.text = getString(R.string.stars_text, numbersString)
    }


}