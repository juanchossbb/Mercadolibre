package com.juanhurtado.mercadolibre.data.datasource

import androidx.paging.DataSource
import com.juanhurtado.mercadolibre.model.Product
import com.juanhurtado.mercadolibre.model.SearchResponse

class ProductsDataSourceFactory(query : String) : DataSource.Factory<Int, Product>(){
    val productDataSource = ProductDataSource().apply { this.query = query }
    override fun create(): DataSource<Int, Product> {
        return productDataSource
    }
}