package be.odisee.tenniscounter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import be.odisee.tenniscounter.data.TennisDatabase
import be.odisee.tenniscounter.databinding.FragmentScoreOverviewBinding

class ScoreOverviewFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentScoreOverviewBinding.inflate(inflater)
        val scoreDao = TennisDatabase.getInstance(requireActivity().applicationContext).scoreDao()
        val factory = ScoreOverviewViewModelFactory(scoreDao)
        val viewModel =
            ViewModelProvider(requireActivity(), factory)[ScoreOverviewViewModel::class.java]
        val adapter = ScoreAdapter { score ->
            viewModel.delete(score)
        }
        binding.recyclerView.adapter = adapter

        viewModel.scores.observe(viewLifecycleOwner) { scores ->
            adapter.submitList(scores)
        }

//        viewModel.scores.observe(viewLifecycleOwner) { scores ->
//            binding.recyclerView.adapter = ScoreAdapter(scores) { score ->
//                viewModel.delete(score)
//            }
//        }

        return binding.root
    }

}