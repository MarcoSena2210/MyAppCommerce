package br.com.msena.myappcommerce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Recupera nosso item*/
        val productItem: LinearLayout =  findViewById(R.id.ll_products_item)
        productItem.setOnClickListener{
           /* Vamos colocar a chamada para nosso produto*/
            val intent: Intent = Intent( this, ProductDetailActivity:: class.java)
            startActivity(intent)
        }
    }
}
