package com.juanhurtado.mercadolibre.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.juanhurtado.mercadolibre.R
import com.juanhurtado.mercadolibre.model.Product
import com.squareup.picasso.Picasso

class SearchResultAdapter(val listener: SearchResultListener) : PagedListAdapter<Product,SearchResultAdapter.SearchResultViewHolder>(Product.DIFF_CALLBACK) {

    class SearchResultViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val ivPhoto = view.findViewById<ImageView>(R.id.iv_item_photo)
        val tvTitle = view.findViewById<TextView>(R.id.tv_item_title)
        val tvPrice = view.findViewById<TextView>(R.id.tv_item_price)
        val tvCondition = view.findViewById<TextView>(R.id.tv_item_condition)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultViewHolder {
       return SearchResultViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_search_result, parent, false))
    }

    override fun onBindViewHolder(holder: SearchResultViewHolder, position: Int) {
        val product = getItem(position)
        Picasso.get().load(product?.thumbnail).fit().into(holder.ivPhoto)
        holder.tvTitle.text = product?.title
        holder.tvPrice.text = String.format(holder.tvPrice.context.getString(R.string.format_price),product?.price.toString(),product?.currencyId)
        holder.tvCondition.text = product?.condition
        holder.itemView.setOnClickListener {
            listener.onProductClicked(product)
        }
    }
}