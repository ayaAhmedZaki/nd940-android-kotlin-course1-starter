package com.udacity.shoestore

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    lateinit var binding : FragmentSplashBinding
    private lateinit var mHandler: Handler

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_splash, container, false)

        mHandler = Handler(Looper.getMainLooper())
        mHandler.postDelayed({
            if (Prefs.getPrefsInstance(requireContext()).getBoolean(Prefs.LOGGING, false))
            {
                Log.d("TAgAc" , "LOGGONG")
                //logging
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToShoeListFragment())
                //navController.popBackStack(R.id.shoeListFragment, false)

            }
            else{
                //not logging
                Log.d("TAgAc" , "Not LOGGONG")
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToLoginFragment())

            }

        }, 2000)



        return binding.root
    }

}