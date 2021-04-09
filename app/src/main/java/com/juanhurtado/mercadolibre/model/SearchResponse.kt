package com.juanhurtado.mercadolibre.model

class SearchResponse : ServiceResponse() {
    lateinit var query : String
    lateinit var results : List<Product>
}