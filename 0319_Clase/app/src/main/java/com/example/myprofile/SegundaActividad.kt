package com.example.myprofile

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SegundaActividad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_actividad)

        val texto = findViewById<TextView>(R.id.textoNombre)
        val nombre = intent.getStringExtra("nombre")

        texto.text = "$nombre, eres un trabajador en Activo"
        texto.setTextColor(Color.BLUE)
    }
}