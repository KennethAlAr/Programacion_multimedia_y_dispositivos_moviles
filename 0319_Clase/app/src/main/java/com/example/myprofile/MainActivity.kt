package com.example.myprofile

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var nombre: EditText
    lateinit var edad: EditText
    lateinit var grupo: RadioGroup
    lateinit var switchNotif: Switch

    lateinit var switchTrabajo: Switch
    lateinit var boton: Button
    lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nombre = findViewById(R.id.campoNombre)
        edad = findViewById(R.id.campoEdad)
        grupo = findViewById(R.id.grupoGenero)
        switchNotif = findViewById(R.id.switchNotificaciones)
        switchTrabajo = findViewById(R.id.switchTrabajo)
        boton = findViewById(R.id.botonGenerar)
        resultado = findViewById(R.id.textoResultado)

        boton.setOnClickListener {
            val nombreTexto = nombre.text.toString()
            val edadTexto = edad.text.toString()

            if (nombreTexto == "" || edadTexto == "") {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val edadNumero = edadTexto.toInt()

            val genero = when(grupo.checkedRadioButtonId){
                R.id.radioHombre -> "Hombre"
                R.id.radioMujer -> "Mujer"
                else -> "No seleccionado"
            }

            val notificaciones = if (switchNotif.isChecked){
                "Activadas"
            } else {
                "Desactivadas"
            }

            val trabajo = if (switchNotif.isChecked){
                "Trabajador en activo"
            } else {
                "Sin trabajo"
            }

            resultado.text = """
                Nombre: $nombreTexto
                Edad: $edadNumero
                Género: $genero
                Notificaciones: $notificaciones
                Trabajo: $trabajo
            """.trimIndent()

            val intent = Intent(this, SegundaActividad::class.java)
            intent.putExtra("nombre", nombreTexto)
            //startActivity(intent)

            if(edadNumero >= 18){
                resultado.setTextColor(Color.GREEN)
                resultado.append("\nMayor de edad")
            }else{
                resultado.setTextColor(Color.RED)
                resultado.append("\nMenor de edad")
            }

            if(switchNotif.isChecked){
                Toast.makeText(this, "Notificaciones activadas", Toast.LENGTH_SHORT).show()
            }

            if(switchTrabajo.isChecked){
                startActivity(intent)
                Toast.makeText(this, "Eres un trabajador en activo", Toast.LENGTH_SHORT).show()
            }

        }

    }
}