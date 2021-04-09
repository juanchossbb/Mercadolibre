package com.juanhurtado.mercadolibre.search

import android.os.Bundle
import androidx.appcompat.widget.SearchView
import com.juanhurtado.mercadolibre.MainActivity
import com.juanhurtado.mercadolibre.R

class SearchActivity : MainActivity(), SearchView.OnQueryTextListener {
    lateinit var searchView: SearchView
    var resultFragment : SearchResultFragment? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        searchView = findViewById(R.id.sv_search)
        searchView.setOnQueryTextListener(this)
        showDefaultFragment()
    }


    private fun showDefaultFragment(){
        val defaultFragment = DefaultSearchFragment.instance
        replaceFragment(defaultFragment)
    }

    fun showResultFragment(query: String){
        if (resultFragment == null){
            resultFragment = SearchResultFragment.getNewInstance(query)
        }
        resultFragment?.let {
            if (!it.isVisible)
                replaceFragment(it, SearchResultFragment::class.simpleName)
            else it.search(query)
        }
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        onQueryTextChange(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        if (newText.isNotEmpty() && newText.length > 2)
            showResultFragment(newText)
        else
            showDefaultFragment()
        return true
    }
}