package br.com.arthurjf.cursoandroid.calculadoraimc.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
class Person(var weight: Double, var height: Double): Parcelable {

}