package com.juanhurtado.mercadolibre.data.database.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.juanhurtado.mercadolibre.model.Product

@Dao
interface ProductDao {
    @Query("SELECT * FROM products")
    fun getAllProducts() : DataSource.Factory<Int, Product>

    @Query("SELECT * FROM products where title like :query limit :initial offset :offset")
    fun searchProducts(query : String, initial : Int, offset : Int) : List<Product>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertProducts(products : List<Product>)
}