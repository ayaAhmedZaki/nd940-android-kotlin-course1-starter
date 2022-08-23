package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    lateinit var binding : FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_login, container, false)

        val buttonsClick : List<View> = listOf(binding.loginBtn , binding.loginExistingBtn)
        for (item in buttonsClick)
        {
            item.setOnClickListener {

                actionNavigate(item)
            }

        }



        return binding.root
    }

    private fun actionNavigate(view: View) {

        if (!(binding.emailEditText.text.isNullOrEmpty()) &&
            !(binding.passwordEditText.text.isNullOrEmpty()) )
        {
            Prefs.getPrefsInstance(requireContext()).edit().putBoolean(Prefs.LOGGING,true).apply()
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }
        else{
            Toast.makeText(requireContext() , getString(R.string.required_field), Toast.LENGTH_SHORT).show()
        }


//        when(view.id)
//        {
//
//        }
    }


}