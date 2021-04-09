package com.juanhurtado.mercadolibre.model

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.juanhurtado.mercadolibre.data.database.TypeConverter
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Entity(tableName = "products")
@TypeConverters(TypeConverter::class)
class Product : Serializable {
    @PrimaryKey(autoGenerate = true)
    var idn : Int = 0
    lateinit var title : String
    lateinit var seller: Seller
    var price : Double = 0.0
    @SerializedName("currency_id")
    lateinit var currencyId : String
    @SerializedName("available_quantity")
    var availableQuantity : Int = 0
    @SerializedName("sold_quantity")
    var soldQuantity : Int = 0
    @SerializedName("buying_mode")
    lateinit var buyingMode : String
    lateinit var condition : String
    lateinit var thumbnail : String
    lateinit var attributes : List<Attribute>

    class Seller : Serializable{
        var id : Long = 0
    }

    class Eshop : Serializable{
        @SerializedName("nick_name")
        lateinit var nickname : String
        @SerializedName("eshop_logo_url")
        lateinit var logoUrl : String
    }

    class Attribute : Serializable{
        lateinit var name : String
        @SerializedName("value_name")
        lateinit var valueName : String
    }

    companion object {
        val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldProduct: Product,
                                         newProduct: Product) = oldProduct.idn == newProduct.idn

            override fun areContentsTheSame(oldProduct: Product,
                                            newProduct: Product) = oldProduct.equals(newProduct)
        }
    }
}