package com.juanhurtado.mercadolibre.data.networking

import com.juanhurtado.mercadolibre.model.SearchResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MercadolibreService {

    @GET("search")
    fun searchProducts(@Query("q") query : String, @Query("limit") limit : Int, @Query("offset") offset : Int) : Single<SearchResponse>
}