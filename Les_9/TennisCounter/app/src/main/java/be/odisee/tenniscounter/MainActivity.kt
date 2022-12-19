package be.odisee.tenniscounter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import be.odisee.tenniscounter.data.TennisDatabase
import be.odisee.tenniscounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val scoreDao = TennisDatabase.getInstance(this.applicationContext).scoreDao()
        val factory = MainViewModelFactory(scoreDao)
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]


        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        binding.player1Button.setOnClickListener {
            viewModel.addScorePlayer1()
        }
        binding.player2Button.setOnClickListener {
            viewModel.addScorePlayer2()

        }

        viewModel.lastFinishedScore.observe(this) {
            if (it != null) {
                binding.previousScore.text = it.toString()
            }
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