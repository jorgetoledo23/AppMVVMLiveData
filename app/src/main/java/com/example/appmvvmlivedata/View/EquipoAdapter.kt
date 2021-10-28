package com.example.appmvvmlivedata.View

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appmvvmlivedata.Model.Equipo
import com.example.appmvvmlivedata.R
import com.example.appmvvmlivedata.databinding.EquipoItemBinding

class EquipoAdapter(var listaEquipos:List<Equipo>):RecyclerView.Adapter<EquipoAdapter.Holder>() {

    class Holder(val view: View):RecyclerView.ViewHolder(view){

        val binding:EquipoItemBinding = EquipoItemBinding.bind(view)

        fun bind(equipo:Equipo){
            binding.tvEquipo.text = equipo.Name
            binding.tvCantidad.text = equipo.ChampionsLeague
            binding.cardView.setOnClickListener{editEquipo(equipo)}
        }

        fun editEquipo(equipo:Equipo){
            val context = view.context
            val intent = Intent(context, ActivityEditEquipo::class.java)
            intent.putExtra("equipo", equipo)
            context.startActivity(intent)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return Holder(layoutInflater.inflate(R.layout.equipo_item, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(listaEquipos[position])
    }

    override fun getItemCount(): Int {
        return listaEquipos.size
    }


}