package com.example.phonepro.domain

import android.os.Parcel
import android.os.Parcelable

 class SelectedModelList(
    val modelList:MutableList<String> ,
):Parcelable {
     constructor(parcel: Parcel) : this(
         parcel.createStringArrayList()?.toMutableList() ?: mutableListOf()
     ) {
     }

     override fun describeContents(): Int {
     return 0
     }

     override fun writeToParcel(dest: Parcel, flags: Int) {

     }

     companion object CREATOR : Parcelable.Creator<SelectedModelList> {
         override fun createFromParcel(parcel: Parcel): SelectedModelList {
             return SelectedModelList(parcel)
         }

         override fun newArray(size: Int): Array<SelectedModelList?> {
             return arrayOfNulls(size)
         }
     }
 }

