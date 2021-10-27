package com.example.appmvvmlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appmvvmlivedata.Model.EquipoProvider
import com.example.appmvvmlivedata.databinding.ActivityVerEquiposBinding

class ActivityVerEquipos : AppCompatActivity() {

    private lateinit var binding: ActivityVerEquiposBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerEquiposBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecycler()

    }

    private fun initRecycler() {
        binding.EquiposRecyclerList.layoutManager = LinearLayoutManager(this)
        val adapter = EquipoAdapter(EquipoProvider.getEquipos())
        binding.EquiposRecyclerList.adapter = adapter
    }
}