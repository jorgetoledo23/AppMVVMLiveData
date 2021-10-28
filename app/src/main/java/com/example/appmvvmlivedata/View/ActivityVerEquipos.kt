package com.example.appmvvmlivedata.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appmvvmlivedata.Model.EquipoProvider
import com.example.appmvvmlivedata.R
import com.example.appmvvmlivedata.databinding.ActivityVerEquiposBinding

class ActivityVerEquipos : AppCompatActivity() {

    private lateinit var binding: ActivityVerEquiposBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerEquiposBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecycler()

    }

    override fun onResume() {
        super.onResume()
        initRecycler()
    }




    private fun initRecycler() {
        binding.EquiposRecyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = EquipoAdapter(EquipoProvider.getEquipos())
        binding.EquiposRecyclerView.adapter = adapter
    }
}