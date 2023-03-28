package br.com.arthurjf.cursoandroid.calculadoraimc.view

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.arthurjf.cursoandroid.calculadoraimc.R
import java.util.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        val buttonClear = findViewById<Button>(R.id.buttonClear)

        val editTextHeight = findViewById<EditText>(R.id.editTextHeight)
        val editTextWeight = findViewById<EditText>(R.id.editTextWeight)

        buttonCalculate.setOnClickListener {
            var isValuesOk = true

            try {
                if (TextUtils.isEmpty(editTextWeight.text)) {
                    editTextWeight.error =
                        getString(R.string.app_home_person_weight_editText_title_error_value_empty)
                    isValuesOk = false
                }

                if (TextUtils.isEmpty(editTextHeight.text)) {
                    editTextHeight.error =
                        getString(R.string.home_person_height_editText_error_value_empty)
                    isValuesOk = false
                }

                if (isValuesOk) {
                    val height = editTextHeight.text.toString().toDouble()
                    val weight = editTextWeight.text.toString().toDouble()

                    if (weight <= 0) {
                        editTextWeight.error =
                            getString(R.string.app_home_person_weight_editText_title_error_value_notAccepted)
                        isValuesOk = false
                    }

                    if (height <= 0) {
                        editTextHeight.error =
                            getString(R.string.home_person_height_editText_error_value_notAccepted)
                        isValuesOk = false
                    }

                    if (isValuesOk) {
                        val imc = weight / (height.pow(2))

                        val formattedResult = String.format(Locale.US, "%.1f", imc)

                        Toast.makeText(this, "Seu IMC: $formattedResult", Toast.LENGTH_LONG).show()
                    }
                }
            } catch (e: Exception) {
                Toast.makeText(
                    this, getString(R.string.home_button_calculate_unknown_error),
                    Toast.LENGTH_LONG
                )
                    .show()
            }
        }

        buttonClear.setOnClickListener {
            editTextHeight.text.clear()
            editTextWeight.text.clear()
        }
    }
}