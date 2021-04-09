package com.juanhurtado.mercadolibre.details

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.juanhurtado.mercadolibre.MainActivity
import com.juanhurtado.mercadolibre.R
import com.juanhurtado.mercadolibre.model.Product

class DetailsActivity : MainActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
    }

    override fun onStart() {
        super.onStart()
        val product = intent.getSerializableExtra(Product::class.simpleName) as Product
        replaceFragment(DetailsFragment.getInstance(product))
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = product.title
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }
}