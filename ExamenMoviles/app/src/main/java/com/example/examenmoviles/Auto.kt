package com.example.examenmoviles
import android.os.Parcel
import android.os.Parcelable

class Auto(var chasis:Int, var nombreMarca: String, var ColorUno:String, var ColorDos:String, var NombreModelo:String, var anio:Int, var idConductor:Int):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(chasis)
        parcel.writeString(nombreMarca)
        parcel.writeString(ColorUno)
        parcel.writeString(ColorDos)
        parcel.writeString(NombreModelo)
        parcel.writeInt(anio)
        parcel.writeInt(idConductor)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Auto> {
        override fun createFromParcel(parcel: Parcel): Auto {
            return Auto(parcel)
        }

        override fun newArray(size: Int): Array<Auto?> {
            return arrayOfNulls(size)
        }
    }
}