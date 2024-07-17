package com.example.phonepro.domain

import android.os.Parcel
import android.os.Parcelable

data class SpinnerObject(
    val image: Int,
    val colorText: String
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(colorText)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SpinnerObject> {
        override fun createFromParcel(parcel: Parcel): SpinnerObject {
            return SpinnerObject(parcel)
        }

        override fun newArray(size: Int): Array<SpinnerObject?> {
            return arrayOfNulls(size)
        }
    }
}


/**
 * : Parcelable {
 *     constructor(parcel: Parcel) : this(
 *         parcel.readInt(),
 *         parcel.readString().toString()
 *     )
 *
 *     override fun writeToParcel(parcel: Parcel, flags: Int) {
 *         parcel.writeInt(image)
 *         parcel.writeString(colorText)
 *     }
 *
 *     override fun describeContents(): Int {
 *         return 0
 *     }
 *
 *     companion object CREATOR : Parcelable.Creator<SpinnerObject> {
 *         override fun createFromParcel(parcel: Parcel): SpinnerObject {
 *             return SpinnerObject(parcel)
 *         }
 *
 *         override fun newArray(size: Int): Array<SpinnerObject?> {
 *             return arrayOfNulls(size)
 *         }
 *     }
 * }
 */
