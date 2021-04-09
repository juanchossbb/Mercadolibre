package com.juanhurtado.mercadolibre.search

import com.juanhurtado.mercadolibre.model.Product

interface SearchResultListener {
    fun onProductClicked(product: Product?)
}