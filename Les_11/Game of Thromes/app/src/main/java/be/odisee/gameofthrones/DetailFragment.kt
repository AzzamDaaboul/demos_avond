package be.odisee.gameofthrones

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import be.odisee.gameofthrones.APIService.API
import be.odisee.gameofthrones.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = FragmentDetailBinding.inflate(inflater, container, false)

        val args = DetailFragmentArgs.fromBundle(requireArguments())

        val factory = DetailViewModelFactory(API.service)
        val viewmodel =
            ViewModelProvider(requireActivity(), factory).get(DetailViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewmodel = viewmodel

//        viewmodel.personage.observe(viewLifecycleOwner) {
//            binding.fullname.text = it.fullName
//            Glide.with(this)
//                .load(it.imageUrl)
//                .apply(
//                    RequestOptions().placeholder(R.drawable.logo)
//                        .error(R.drawable.ic_launcher_background)
//                )
//                .into(binding.image)
//        }

        viewmodel.loadPersonage((args.id))



        return binding.root
    }

}