package com.example.gestortiempo

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var campoActividad: EditText
    lateinit var botonAgregar: Button
    lateinit var eliminarTareas: Button
    lateinit var listaTareas: ListView
    lateinit var contadorTareas: TextView
    var tareas = ArrayList<String>()
    lateinit var adaptador: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        campoActividad = findViewById(R.id.campoActividad)
        botonAgregar = findViewById(R.id.botonAgregar)
        listaTareas = findViewById(R.id.listaTareas)
        contadorTareas = findViewById(R.id.contadorTareas)
        eliminarTareas = findViewById(R.id.botonEliminarTareas)

        adaptador = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            tareas
        )

        listaTareas.adapter = adaptador

        botonAgregar.setOnClickListener {
            agregarTarea()
        }

        listaTareas.setOnItemClickListener { parent, view, position, id ->
            tareas.removeAt(position)
            adaptador.notifyDataSetChanged()
            actualizarContador()
        }

        eliminarTareas.setOnClickListener {
            Toast.makeText(this, "Eliminadas ${tareas.size} tareas", Toast.LENGTH_SHORT).show()
            tareas.clear()
            adaptador.notifyDataSetChanged()
            actualizarContador()
        }
    }

    fun actualizarContador(){
        contadorTareas.text = "Tareas: ${tareas.size}"
    }

    fun agregarTarea(){
        val tarea = campoActividad.text.toString()
        if(tarea != ""){
            if(tarea.length > 20){
                Toast.makeText(this, "Texto demasiado largo, Máximo 20 caracteres", Toast.LENGTH_SHORT).show()
                return
            }
            if (!tareas.contains(tarea)) {
                tareas.add(tarea)
                adaptador.notifyDataSetChanged()
                campoActividad.setText("")
                actualizarContador()
                Toast.makeText(this, "Tarea añadida", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Tarea repetida", Toast.LENGTH_SHORT).show()
            }
        }
    }
}