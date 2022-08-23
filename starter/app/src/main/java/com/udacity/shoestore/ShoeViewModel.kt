package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel() : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList


    private val _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name
    var shoeNameEditText = ""

    private val _size = MutableLiveData<Double>()
    val size: LiveData<Double>
        get() = _size
    var shoeSizeEditText = ""

    private val _company = MutableLiveData<String>()
    val company: LiveData<String>
        get() = _company
    var shoeCompanyEditText = ""

    private val _description = MutableLiveData<String>()
    val description: LiveData<String>
        get() = _description
    var shoeDesciptionEditText = ""


    private val _navigateBackToListing = MutableLiveData<Boolean>()
    val navigateBackToListing: LiveData<Boolean>
        get() = _navigateBackToListing



    init {
        _shoeList.value = mutableListOf()
//        _name.value = ""
//        _size.value = ""
//        _company.value = ""
//        _description.value = ""

        _navigateBackToListing.value = false


    }

    fun saveBtnClickAddShoe()
    {

//        if (shoeCompanyEditText == "") {
//
//            shoeCompanyEditText = "0"
//        }
        Log.d("TAGDMode" , "editText ${shoeNameEditText}")
        if (shoeSizeEditText == "") {
            shoeSizeEditText = "0"
        }

        _name.value = shoeNameEditText
        _size.value = shoeSizeEditText.toDouble()
        _company.value = shoeCompanyEditText
        _description.value = shoeDesciptionEditText

        _navigateBackToListing.value = true

        _shoeList.value?.add(Shoe(shoeNameEditText , shoeCompanyEditText ,
            shoeSizeEditText.toDouble(), shoeDesciptionEditText ))
        Log.d("TAGDMode" , "TESTTTTT ${_shoeList.value?.size}")
        Log.d("TAGDMode" , "data ${_shoeList.value?.get(0)?.name}")

    }

    fun setNavigation()
    {
        //remove observeOfBack
        _navigateBackToListing.value = false

        //remove data
        _name.value = ""
        _size.value = 0.0
        _company.value = ""
        _description.value = ""

        //remove editText data
        shoeNameEditText = ""
        shoeSizeEditText = ""
        shoeCompanyEditText = ""
        shoeDesciptionEditText = ""
    }




}