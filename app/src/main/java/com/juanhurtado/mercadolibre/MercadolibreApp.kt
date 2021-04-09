package com.juanhurtado.mercadolibre

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager

class MercadolibreApp : Application(){
    init {
        instance = this
    }

    companion object {
        var instance: MercadolibreApp? = null
        fun applicationContext(): Context {
            return instance!!.applicationContext
        }

        fun connectedToInternet(): Boolean {
            val connectivityManager =
                applicationContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
        }
    }
}