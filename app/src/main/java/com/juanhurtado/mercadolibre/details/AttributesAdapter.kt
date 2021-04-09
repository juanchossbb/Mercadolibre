package com.juanhurtado.mercadolibre.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.juanhurtado.mercadolibre.R
import com.juanhurtado.mercadolibre.model.Product

class AttributesAdapter(val attributeList : List<Product.Attribute>) : RecyclerView.Adapter<AttributesAdapter.AttributesViewHolder>() {


    class AttributesViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val tvTitle = view.findViewById<TextView>(R.id.tv_item_attributes_title)
        val tvValue = view.findViewById<TextView>(R.id.tv_item_attributes_value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttributesViewHolder {
        return AttributesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_attributes, parent, false))
    }

    override fun onBindViewHolder(holder: AttributesViewHolder, position: Int) {
        val attributes = attributeList[position]
       holder.tvTitle.text = attributes.name
        holder.tvValue.text = attributes.valueName
    }

    override fun getItemCount(): Int = attributeList.size
}