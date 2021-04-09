package com.juanhurtado.mercadolibre

import android.content.Context
import androidx.room.Room
import com.juanhurtado.mercadolibre.data.database.AppDatabase
import com.juanhurtado.mercadolibre.data.networking.MercadolibreApi
import com.juanhurtado.mercadolibre.data.networking.MercadolibreService

class Injections {

    companion object{
        fun getAppDB() = Room.databaseBuilder(MercadolibreApp.applicationContext(),AppDatabase::class.java, "mercadolibre-db").build()
        fun getMercadolibreService() = MercadolibreApi.retrofit.create(MercadolibreService::class.java)
    }
}