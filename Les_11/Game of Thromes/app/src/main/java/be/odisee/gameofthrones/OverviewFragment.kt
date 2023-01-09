package be.odisee.gameofthrones

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import be.odisee.gameofthrones.APIService.API
import be.odisee.gameofthrones.databinding.FragmentOverviewBinding


class OverviewFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentOverviewBinding.inflate(inflater, container, false)

        val factory = OverviewViewModelFactory(API.service)
        val viewmodel =
            ViewModelProvider(requireActivity(), factory).get(OverviewViewModel::class.java)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val personageAdapter = PersonageAdapter {
            findNavController().navigate(
                OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(
                    it
                )
            )
        }
        binding.recyclerView.adapter = personageAdapter

        viewmodel.personages.observe(viewLifecycleOwner) {
            personageAdapter.submitList(it)
        }

        viewmodel.loadPersonages()


        return binding.root
    }


}
