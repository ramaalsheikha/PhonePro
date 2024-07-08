package com.example.phonepro.domain

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class ObjectModel(
    val image:Int,
    val modelName: String,
    val price: String,
    val description:String,
    ) :Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(modelName)
        parcel.writeString(price)
        parcel.writeString(description)
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



