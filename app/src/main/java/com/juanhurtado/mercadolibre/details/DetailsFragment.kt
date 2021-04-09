package com.juanhurtado.mercadolibre.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.juanhurtado.mercadolibre.R
import com.juanhurtado.mercadolibre.model.Product
import com.squareup.picasso.Picasso

class DetailsFragment : Fragment() {
    lateinit var tvCondition : TextView
    lateinit var ivPhoto : ImageView
    lateinit var tvPrice : TextView
    lateinit var rvAttributes : RecyclerView
    lateinit var tvDescripcion : TextView
    lateinit var tvSeller : TextView
    lateinit var tvSold : TextView
    lateinit var tvAvailable : TextView
    lateinit var tvTitle : TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val product = arguments?.getSerializable("product") as Product
        tvCondition = view.findViewById(R.id.tv_details_condition)
        ivPhoto = view.findViewById(R.id.iv_details_photo)
        tvPrice = view.findViewById(R.id.tv_details_price)
        rvAttributes = view.findViewById(R.id.rv_details_attributes)
        tvSeller = view.findViewById(R.id.tv_details_seller)
        tvSold = view.findViewById(R.id.tv_details_sold)
        tvAvailable = view.findViewById(R.id.tv_details_available)
        tvTitle = view.findViewById(R.id.tv_details_title)
        populateViews(product)

    }

    private fun populateViews(product: Product){
        tvTitle.text = product.title
        tvCondition.text = product.condition
        tvPrice.text = String.format(tvPrice.context.getString(R.string.format_price),product.price.toString(),product.currencyId)
        tvAvailable.text = String.format(tvAvailable.context.getString(R.string.format_available),product.availableQuantity)
        tvSold.text = String.format(tvSold.context.getString(R.string.format_sold),product.soldQuantity)
        tvSeller.text = String.format(tvSeller.context.getString(R.string.format_seller),product.seller.id)
        Picasso.get().load(product.thumbnail).fit().into(ivPhoto)
        rvAttributes.adapter = AttributesAdapter(product.attributes)
        rvAttributes.layoutManager = LinearLayoutManager(requireContext())
    }

    companion object{
        fun getInstance(product: Product) : DetailsFragment{
            return DetailsFragment().apply { arguments = bundleOf("product" to product) }
        }
    }

}