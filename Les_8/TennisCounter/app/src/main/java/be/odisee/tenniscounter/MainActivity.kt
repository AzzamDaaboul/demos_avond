package be.odisee.tenniscounter

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import be.odisee.tenniscounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        binding.player1Button.setOnClickListener {
            viewModel.addScorePlayer1()
        }
        binding.player2Button.setOnClickListener {
            viewModel.addScorePlayer2()

        }

        viewModel.resetVisibility.observe(this) {
            binding.resetButton.visibility = it
        }
        
//        binding.resetButton.setOnClickListener {
//            viewModel.resetScores()
//        }

        viewModel.gameScorePlayer1.observe(this) {
            binding.gamePointsPlayer1.text = it.toString()
        }

        viewModel.gameScorePlayer2.observe(this) {
            binding.gamePointsPlayer2.text = it.toString()
        }

    }
}