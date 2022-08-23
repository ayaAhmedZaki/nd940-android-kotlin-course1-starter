package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe


class ShoeListFragment : Fragment()  {


    lateinit var bindig : FragmentShoeListBinding
    val viewModel: ShoeViewModel by activityViewModels()
   // var dataList = ArrayList<Shoe>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindig = DataBindingUtil.inflate(inflater ,R.layout.fragment_shoe_list, container, false )
        //viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)

        return bindig.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("TAGMain" , "rrrr")


        viewModel.shoeList.observe(viewLifecycleOwner) { shoeList ->
            Log.d("TAGMain" , "TESTTTTT ${shoeList.size}")
            shoeList.forEach{
                Log.d("TAGMain" , "data ${shoeList}")
                val nameText = TextView(requireContext())
                val sizeText = TextView(requireContext())
                val companyText = TextView(requireContext())
                val descText = TextView(requireContext())

                nameText.text = it.name
                sizeText.text = it.size.toString()
                companyText.text = it.company
                descText.text = it.description

                setViews(nameText)
                setViews(sizeText)
                setViews(companyText)
                setViews(descText)

                bindig.linearlayoutContainer.addView(nameText)
                bindig.linearlayoutContainer.addView(sizeText)
                bindig.linearlayoutContainer.addView(companyText)
                bindig.linearlayoutContainer.addView(descText)


            }



//            for (item in dataList.indices)
//            {
//
//                myLayout.addView(nameText)
//            }





            //Log.d("DATA TAG" , "Data ${dataList.get(0).name}")

        }




        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.logout_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                Prefs.getPrefsInstance(requireContext()).edit().putBoolean(Prefs.LOGGING,false).apply()
                findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())

                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)


        bindig.fab.setOnClickListener {

            viewModel.setNavigation()
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        if (Prefs.getPrefsInstance(requireContext()).getBoolean(Prefs.LOGGING, false))
        {
            //logging
//            val callback: OnBackPressedCallback =
//                object : OnBackPressedCallback(true /* enabled by default */) {
//                    override fun handleOnBackPressed() {
//                        // Handle the back button even
//                        Log.d("BACKBUTTON", "Back button clicks")
//                    }
//                }
//
//            requireActivity().onBackPressedDispatcher.addCallback(requireActivity(), callback)

        }
        else{
            //not logging

        }


    }

    private fun setViews(textView: TextView) {

        textView.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        textView.setPadding(16 , 0 , 16 , 16)
    }



}