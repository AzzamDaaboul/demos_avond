package be.odisee.navexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import be.odisee.navexample.databinding.FragmentThirdBinding


class ThirdFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentThirdBinding.inflate(inflater)
        val demo = requireArguments()
        val args = ThirdFragmentArgs.fromBundle(requireArguments())

        binding.text = args.text
        return binding.root
    }

}