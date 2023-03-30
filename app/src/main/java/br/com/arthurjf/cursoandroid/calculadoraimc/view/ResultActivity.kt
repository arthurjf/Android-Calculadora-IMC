package br.com.arthurjf.cursoandroid.calculadoraimc.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import br.com.arthurjf.cursoandroid.calculadoraimc.R
import br.com.arthurjf.cursoandroid.calculadoraimc.model.IMCModel
import br.com.arthurjf.cursoandroid.calculadoraimc.model.Person
import java.util.*

class ResultActivity : AppCompatActivity() {
    companion object {
        val PERSON_KEY_SENDER = "PERSON_KEY_SENDER"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val person = intent.getParcelableExtra<Person>(PERSON_KEY_SENDER)
        val imc = IMCModel(this, person!!.weight, person.height)

        val resultTextView = findViewById<TextView>(R.id.textViewIMC)
        val resultClassificationTextView = findViewById<TextView>(R.id.textViewIMCClassification)
        val weightTextView = findViewById<TextView>(R.id.textViewWeightPerson)
        val heightTextView = findViewById<TextView>(R.id.textViewHeightPerson)

        val weightText = getString(R.string.result_weight_editText_person)
        val heightText = getString(R.string.result_height_editText_person)

        weightTextView.text = String.format(Locale.US, weightText, person.weight)
        heightTextView.text = String.format(Locale.US, heightText, person.height)
        resultTextView.text = String.format(Locale.US, "%.1f", imc.getIMC())
        resultClassificationTextView.text = imc.getClassificationString()

        val buttonReturn = findViewById<Button>(R.id.buttonReturn)

        buttonReturn.setOnClickListener {
            finish()
        }
    }
}