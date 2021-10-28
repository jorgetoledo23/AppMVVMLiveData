package com.example.appmvvmlivedata.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appmvvmlivedata.Data.EquiposDb
import com.example.appmvvmlivedata.Model.Equipo
import com.example.appmvvmlivedata.databinding.ActivityAddEquipoBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddEquipo : AppCompatActivity() {

    private lateinit var binding: ActivityAddEquipoBinding
    private lateinit var database: EquiposDb


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEquipoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = EquiposDb.getDatabase(this)

        binding.btnAddEquipo.setOnClickListener { addLibro() }

    }

    private fun addLibro() {
        val Nombre = binding.txtEquipo.editText?.text.toString()
        val Cantidad = binding.txtCantidad.editText?.text.toString()

        val equipo:Equipo = Equipo(Name = Nombre, ChampionsLeague = Cantidad)

        CoroutineScope(Dispatchers.IO).launch {
            database.equipoDao().addEquipos(equipo)
            this@AddEquipo.finish()
        }


    }
}