package com.example.phonepro.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CustomerList (
    val paymentList:MutableList<String>
):Parcelable