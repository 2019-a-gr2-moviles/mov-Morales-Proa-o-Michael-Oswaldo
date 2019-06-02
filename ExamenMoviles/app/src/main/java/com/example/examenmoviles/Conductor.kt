package com.example.examenmoviles

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import android.support.annotation.RequiresApi
import java.time.LocalDate
import java.util.*

class Conductor(val nombres: String, val apellidos:String, val fechaNacimiento: LocalDate, val numeroAutos:Int, val licenciaValida:Boolean) : Parcelable {
    @RequiresApi(Build.VERSION_CODES.O)
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readSerializable() as LocalDate,
        parcel.readInt(),
        parcel.readByte() != 0.toByte()
    ) {
    }
    var autos = arrayListOf<Auto>()

    fun AñadirAuto( auto:Auto){
        autos.add(auto)
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombres)
        parcel.writeString(apellidos)
        parcel.writeInt(numeroAutos)
        parcel.writeByte(if (licenciaValida) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Conductor> {
        @RequiresApi(Build.VERSION_CODES.O)
        override fun createFromParcel(parcel: Parcel): Conductor {
            return Conductor(parcel)
        }

        override fun newArray(size: Int): Array<Conductor?> {
            return arrayOfNulls(size)
        }
    }

}