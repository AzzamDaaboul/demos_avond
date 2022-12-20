package be.odisee.tenniscounter

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import be.odisee.tenniscounter.data.TennisDatabase
import be.odisee.tenniscounter.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentGameBinding.inflate(inflater)

        val scoreDao = TennisDatabase.getInstance(requireActivity().applicationContext).scoreDao()
        val factory = MainViewModelFactory(scoreDao)
        val viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        requireActivity().addMenuProvider(
            object : MenuProvider {
                override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                    menuInflater.inflate(R.menu.menu, menu)
                }

                override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                    if (menuItem.itemId == R.id.history) {
                        findNavController().navigate(GameFragmentDirections.actionGameFragmentToScoreOverviewFragment())
                        return true
                    }
                    return false
                }
            }, viewLifecycleOwner, Lifecycle.State.RESUMED
        )

        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.player1Button.setOnClickListener {
            viewModel.addScorePlayer1()
        }
        binding.player2Button.setOnClickListener {
            viewModel.addScorePlayer2()

        }

        viewModel.lastFinishedScore.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.previousScore.text = it.toString()
            }
        }

        viewModel.resetVisibility.observe(viewLifecycleOwner) {
            binding.resetButton.visibility = it
        }

//        binding.resetButton.setOnClickListener {
//            viewModel.resetScores()
//        }

        viewModel.gameScorePlayer1.observe(viewLifecycleOwner) {
            binding.gamePointsPlayer1.text = it.toString()
        }

        viewModel.gameScorePlayer2.observe(viewLifecycleOwner) {
            binding.gamePointsPlayer2.text = it.toString()
        }

        return binding.root
    }
}