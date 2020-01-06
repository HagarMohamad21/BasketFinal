package net.zonetech.elbasket.Models

import android.os.Parcel
import android.os.Parcelable

data class Offer(var offerCategory:String="",
                 var offerDiscount:String="",
                 var offerName:String="",
                 var offerImage:Int=-1): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(offerCategory)
        parcel.writeString(offerDiscount)
        parcel.writeString(offerName)
        parcel.writeInt(offerImage)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Offer> {
        override fun createFromParcel(parcel: Parcel): Offer {
            return Offer(parcel)
        }

        override fun newArray(size: Int): Array<Offer?> {
            return arrayOfNulls(size)
        }
    }
}