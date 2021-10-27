package com.example.appmvvmlivedata

import android.media.audiofx.DynamicsProcessing
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appmvvmlivedata.Model.Equipo
import com.example.appmvvmlivedata.databinding.EquipoitemBinding

class EquipoAdapter(val listaEquipos:List<Equipo>):RecyclerView.Adapter<EquipoAdapter.Holder>() {

    class Holder (val view: View):RecyclerView.ViewHolder(view) {

        val binding:EquipoitemBinding = EquipoitemBinding.bind(view)
        fun bind(equipo:Equipo){
            binding.tvEquipo.text = equipo.Name
            binding.tvCantidad.text = equipo.ChampionsLeague
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return Holder(layoutInflater.inflate(R.layout.equipoitem, parent, false))

    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(listaEquipos[position])
    }

    override fun getItemCount(): Int {
        return listaEquipos.size
    }


}


