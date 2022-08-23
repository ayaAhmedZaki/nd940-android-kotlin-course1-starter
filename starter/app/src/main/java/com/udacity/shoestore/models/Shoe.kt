package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(var name: String,var company: String, var size: Double,  var description: String,
                val images: List<String> = mutableListOf()) : Parcelable