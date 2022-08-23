package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentSheoDetailBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailFragment : Fragment() {

    lateinit var binding: FragmentSheoDetailBinding
    val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater ,R.layout.fragment_sheo_detail, container, false )

        //viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sharedShoeViewModel = viewModel

        viewModel.navigateBackToListing.observe(
            viewLifecycleOwner) { navigateBack ->

            if (navigateBack) {
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
            }
        }



                binding.cancelBtn.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

//        binding.saveBtn.setOnClickListener {
//
//            if (!(binding.nameEditText.text.isNullOrEmpty()) &&
//                !(binding.companyEditText.text.isNullOrEmpty()) &&
//                !(binding.sizeEditText.text.isNullOrEmpty()) &&
//                !(binding.descriptionEditText.text.isNullOrEmpty())
//                    )
//            {
//                viewModel.addNewShoe(binding.nameEditText.text.toString() ,
//                    binding.companyEditText.text.toString() ,
//                    binding.sizeEditText.text.toString().toDouble() ,
//                    binding.descriptionEditText.text.toString())
//
//                viewModel.shoeList.observe(viewLifecycleOwner) { viewState ->
//                    // dataList.addAll(viewState)
//
//                    Log.d("TAGDEtail" , "TESTTTTT ${viewState.size}")
//
//                    //Log.d("DATA TAG" , "Data ${dataList.get(0).name}")
//
//                }
//
//                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
//            }
//            else{
//                Toast.makeText(requireContext() , getString(R.string.required_field) , Toast.LENGTH_SHORT).show()
//            }
//
//        }
    }
}