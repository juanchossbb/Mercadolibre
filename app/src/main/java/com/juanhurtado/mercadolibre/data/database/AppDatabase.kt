package com.juanhurtado.mercadolibre.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.juanhurtado.mercadolibre.data.database.dao.ProductDao
import com.juanhurtado.mercadolibre.model.Product

@Database(entities = [Product::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun productsDao() : ProductDao
}