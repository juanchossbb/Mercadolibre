package com.juanhurtado.mercadolibre.data.datasource

import androidx.paging.PositionalDataSource
import com.juanhurtado.mercadolibre.Injections
import com.juanhurtado.mercadolibre.MercadolibreApp
import com.juanhurtado.mercadolibre.model.Product

val service = Injections.getMercadolibreService()
val database = Injections.getAppDB()
class ProductDataSource : PositionalDataSource<Product>() {
    var query = ""
    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Product>) {
        callback.onResult(loadRangeInternal(0,params.pageSize), params.requestedStartPosition)
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Product>) {
        callback.onResult(loadRangeInternal(params.startPosition,params.loadSize))
    }

    private fun loadRangeInternal(start : Int, count : Int) : List<Product>{

        if (MercadolibreApp.connectedToInternet()) {
            val products = service.searchProducts(query,count, start).doOnError {
                it.printStackTrace()
            }.blockingGet().results
            database.productsDao().insertProducts(products)
        }
        return database.productsDao().searchProducts("%$query%",count,start)
    }
}