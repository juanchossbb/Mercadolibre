package com.juanhurtado.mercadolibre.model

import com.google.gson.annotations.SerializedName

open class ServiceResponse {
    @SerializedName("site_id")
    lateinit var siteId : String
    lateinit var paging : Paging


    class Paging{
        var total : Int = 0
        @SerializedName("primary_results")
        var primaryResults = 0
        var offset = 0
        var limit = 0

    }
}