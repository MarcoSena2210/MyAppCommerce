package br.com.msena.myappcommerce

import android.os.Bundle
import android.widget.TextView

import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.widget.TextViewCompat

import kotlinx.android.synthetic.main.activity_product_detail.*


class ProductDetailActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var textTitle : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(this.toolbar)

       /* Colocando a seta para voltar, é colocado a ?
          porque esse objeto pode ser null, para funcionar precisa
          subscrever o metodo onSupportNavigateUp   */
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        /* Para não ficar os dois titulos da barra.O da App e o do produto   */
        supportActionBar?.setDisplayShowTitleEnabled(false)

        textTitle = findViewById(R.id.toolbar_title)
        textTitle.text = "Titulo do Produto"

    }

    /* Subscrevendo o metodo para volta ao ser clicado a seta  */
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
