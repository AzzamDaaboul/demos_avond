package be.odisee.navexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import be.odisee.navexample.databinding.FragmentFirstBinding

class FirstFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =  FragmentFirstBinding.inflate(inflater)

        binding.goToSecondFragmentButton.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        binding.goToThirdFragmentButton.setOnClickListener {
            findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToThirdFragment("test"))
        }
        return binding.root
    }
}