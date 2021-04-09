package com.juanhurtado.mercadolibre.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.juanhurtado.mercadolibre.data.database.dao.ProductDao
import com.juanhurtado.mercadolibre.data.datasource.ProductsDataSourceFactory
import com.juanhurtado.mercadolibre.model.Product

private const val PAGE_SIZE = 50
class SearchResultViewModel() : ViewModel() {
   lateinit var productList : LiveData<PagedList<Product>>

   fun loadProductList(query : String){
       val config = PagedList.Config.Builder()
           .setPrefetchDistance(PAGE_SIZE / 2)
           .setPageSize(PAGE_SIZE)
           .setEnablePlaceholders(false)
           .build()
       productList = LivePagedListBuilder(ProductsDataSourceFactory(query), config).build()
   }

}