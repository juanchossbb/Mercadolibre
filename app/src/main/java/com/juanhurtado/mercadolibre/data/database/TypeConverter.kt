package com.juanhurtado.mercadolibre.data.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.juanhurtado.mercadolibre.model.Product
import java.lang.reflect.Type


class TypeConverter {

    @TypeConverter
    fun sellerToString(seller: Product.Seller) : String{
        return Gson().toJson(seller)
    }

    @TypeConverter
    fun stringToSeller(string: String) : Product.Seller {
        return Gson().fromJson<Product.Seller>(string, Product.Seller::class.java)
    }

    @TypeConverter
    fun attributesToString(attribute: List<Product.Attribute>) : String{
        return Gson().toJson(attribute)
    }

    @TypeConverter
    fun stringToAttribute(string: String) : List<Product.Attribute>{
        val type: Type = object : TypeToken<List<Product.Attribute?>?>() {}.type
        return Gson().fromJson(string, type)
    }
}