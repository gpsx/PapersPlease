package gps.x.papersplease

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        confirmationButton.setOnClickListener {
            bindConfirmation()
        }
    }

    fun bindConfirmation(){
        var text = ""

        if (name.text.length < 5) text += "Nome inválido"
        if (passport.text.length < 8) text += ", Passaporte inválido"
        if (purpose.text.toString() != "Trabalho" && purpose.text.toString() != "Estudo") text += ", Só é permitido entrar para trabalho ou estudo"
        if (duration.text.toString().toInt() > 3) text += " o passe só pode durar no máximo 3 meses"

        if (text.isEmpty()) {
            result.text = "Entrada LIBERADA"
            result.setTextColor(ContextCompat.getColor(this, R.color.canEnter))
        }  else {
            result.text = "Entrada NEGADA: $text"
        }
    }
}