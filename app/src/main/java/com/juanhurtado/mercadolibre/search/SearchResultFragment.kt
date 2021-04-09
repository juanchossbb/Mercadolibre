package com.juanhurtado.mercadolibre.search

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.juanhurtado.mercadolibre.Injections
import com.juanhurtado.mercadolibre.R
import com.juanhurtado.mercadolibre.details.DetailsActivity
import com.juanhurtado.mercadolibre.model.Product
import io.reactivex.disposables.CompositeDisposable
private const val QUERY = "query"
class SearchResultFragment : Fragment(), SearchResultListener{

    val viewmodel = SearchResultViewModel()
    lateinit var recyclerView: RecyclerView
    var adapter = SearchResultAdapter(this)
    lateinit var query: String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_result,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.rv_search_result)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        query = arguments?.getString(QUERY).orEmpty()
        search(query)
    }

    fun search(query : String){
        adapter = SearchResultAdapter(this)
        recyclerView.adapter = adapter
        viewmodel.loadProductList(query)
        viewmodel.productList.observe(this, Observer {
            adapter.submitList(it)
        })
    }

    companion object{
        fun getNewInstance(query : String): SearchResultFragment {
            return SearchResultFragment().apply { arguments = bundleOf(QUERY to query) }
        }
    }

    override fun onProductClicked(product: Product?) {
        val intent = Intent(requireContext(),DetailsActivity::class.java).apply {
            putExtra(Product::class.simpleName, product)
        }
        startActivity(intent)
    }

}