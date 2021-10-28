package com.example.appmvvmlivedata.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appmvvmlivedata.Data.EquiposDb
import com.example.appmvvmlivedata.Model.Equipo
import com.example.appmvvmlivedata.Model.EquipoProvider
import com.example.appmvvmlivedata.databinding.ActivityEditEquipoBinding
import com.example.appmvvmlivedata.databinding.ActivityVerEquiposBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActivityEditEquipo : AppCompatActivity() {

    private lateinit var binding:ActivityEditEquipoBinding
    private lateinit var database:EquiposDb


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditEquipoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = EquiposDb.getDatabase(this)
        database.equipoDao().getAll().observe(this, {
            EquipoProvider.setEquipos(it)
        })


        val bundle = intent.extras
        val equipo: Equipo = bundle?.getSerializable("equipo") as Equipo

        binding.tvNombre.text = equipo.Name
        binding.tvChampions.text = equipo.ChampionsLeague


        binding.btnEditEquipo.setOnClickListener { uptEquipo(equipo) }

    }

    private fun uptEquipo(equipo: Equipo) {
        var nombre = binding.txtEquipo.editText?.text.toString()
        var cantidad = binding.txtCantidad.editText?.text.toString()

        var equipoEditado = Equipo(EquipoId = equipo.EquipoId, Name = nombre, ChampionsLeague = cantidad)

        CoroutineScope(Dispatchers.IO).launch {
            database.equipoDao().uptEquipos(equipoEditado)
            this@ActivityEditEquipo.finish()
        }

    }
}