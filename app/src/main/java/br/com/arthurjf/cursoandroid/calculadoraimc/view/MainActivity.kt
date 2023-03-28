package br.com.arthurjf.cursoandroid.calculadoraimc.view

import android.os.Bundle
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
            val calculoTeste =
                editTextWeight.text.toString().toDouble() / (editTextHeight.text.toString()
                    .toDouble().pow(2))

            val roundOff = String.format(Locale.US, "%.1f", calculoTeste)
            Toast.makeText(this, "Seu IMC: $roundOff", Toast.LENGTH_LONG).show()
        }

        buttonClear.setOnClickListener {
            editTextHeight.text.clear()
            editTextWeight.text.clear()
        }
    }
}