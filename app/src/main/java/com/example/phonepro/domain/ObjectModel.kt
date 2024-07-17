package com.example.phonepro.domain

import android.os.Parcel
import android.os.Parcelable

data class ObjectModel(
    val image: Int,
    val modelName: String,
    val price: String,
    val description: String,
    val color: ArrayList<SpinnerObject>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.createTypedArrayList(SpinnerObject.CREATOR) ?: arrayListOf()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(modelName)
        parcel.writeString(price)
        parcel.writeString(description)
        parcel.writeTypedList(color)
    }

    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<ObjectModel> {
        override fun createFromParcel(parcel: Parcel): ObjectModel {
            return ObjectModel(parcel)
        }

        override fun newArray(size: Int): Array<ObjectModel?> {
            return arrayOfNulls(size)
        }
    }
}