package br.com.msena.myappcommerce

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
       /* Colocando a seta para voltar, é colocado a ?
          porque esse objeto pode ser null, para funcionar precisa
          subscrever o metodo onSupportNavigateUp   */
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    /* Subscrevendo o metodo para volta ao ser clicado a seta  */
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
