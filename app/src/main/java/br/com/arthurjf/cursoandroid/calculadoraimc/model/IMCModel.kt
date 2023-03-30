package br.com.arthurjf.cursoandroid.calculadoraimc.model

import android.content.Context
import br.com.arthurjf.cursoandroid.calculadoraimc.R
import java.util.*
import kotlin.math.pow

class IMCModel(
    private val context: Context,
    private var weight: Double,
    private var height: Double
) {
    private val CLASSIFICAO_MAGREZA = 18.5
    private val CLASSIFICAO_SAUDAVEL_MIN = 18.5
    private val CLASSIFICAO_SAUDAVEL_MAX = 24.9
    private val CLASSIFICAO_SOBREPRESO_MIN = 25.0
    private val CLASSIFICAO_SOBREPRESO_MAX = 29.9
    private val CLASSIFICAO_OBESIDADE_GRAU_UM_MIN = 30.0
    private val CLASSIFICAO_OBESIDADE_GRAU_UM_MAX = 34.9
    private val CLASSIFICAO_OBESIDADE_GRAU_DOIS_MIN = 35.0
    private val CLASSIFICAO_OBESIDADE_GRAU_DOIS_MAX = 39.9

    fun getIMC(): Double {
        return weight / (height.pow(2))
    }

    fun getClassificationString(): String{
        val imc = getIMC()
        if (imc < CLASSIFICAO_MAGREZA) {
            return context.getString(R.string.imc_underweight)
        } else if (imc in CLASSIFICAO_SAUDAVEL_MIN..CLASSIFICAO_SAUDAVEL_MAX) {
            return context.getString(R.string.imc_healthy)
        } else if (imc in CLASSIFICAO_SOBREPRESO_MIN..CLASSIFICAO_SOBREPRESO_MAX) {
            return context.getString(R.string.imc_overweight)
        } else if (imc in CLASSIFICAO_OBESIDADE_GRAU_UM_MIN..CLASSIFICAO_OBESIDADE_GRAU_UM_MAX) {
            return context.getString(R.string.imc_obesity_class_i)
        } else if (imc in CLASSIFICAO_OBESIDADE_GRAU_DOIS_MIN..CLASSIFICAO_OBESIDADE_GRAU_DOIS_MAX) {
            return context.getString(R.string.imc_obesity_class_ii)
        }
        return context.getString(R.string.imc_obesity_class_iii)
    }

    override fun toString(): String {
        val imc = getIMC()

        return String.format(Locale.US, "%.1f", imc)
    }
}