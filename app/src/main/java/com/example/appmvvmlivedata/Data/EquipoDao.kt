package com.example.appmvvmlivedata.Data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.appmvvmlivedata.Model.Equipo

@Dao
interface EquipoDao {

    @Query("SELECT * FROM Equipos")
    fun getAll(): LiveData<List<Equipo>>

    @Insert
    fun addEquipos(vararg equipo:Equipo)

    @Update
    fun uptEquipos(vararg equipo:Equipo)

}