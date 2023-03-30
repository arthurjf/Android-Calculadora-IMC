package br.com.arthurjf.cursoandroid.calculadoraimc.model

import kotlin.math.pow

class IMCModel(private var weight: Double, private var height: Double) {
    fun getIMC(): Double {
        return weight / (height.pow(2))
    }
}