package com.juanhurtado.mercadolibre.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.juanhurtado.mercadolibre.R

class DefaultSearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_default,container,false)
    }

    companion object{
        val instance = DefaultSearchFragment()
    }
}