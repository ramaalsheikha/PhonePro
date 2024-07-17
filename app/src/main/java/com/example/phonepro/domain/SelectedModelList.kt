package com.example.phonepro.domain

import android.os.Parcel
import android.os.Parcelable

data class SelectedModelList(
    val modelList: MutableList<String>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.createStringArrayList() ?.toMutableList()?: mutableListOf()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeStringList(modelList)
    }

    override fun describeContents(): Int {
        return 0
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
