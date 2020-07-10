package br.com.msena.myappcommerce.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.msena.myappcommerce.R
import br.com.msena.myappcommerce.ProductDetailActivity
import br.com.msena.myappcommerce.model.Product
import br.com.msena.myappcommerce.model.ProductCategory

class ProductAdapter (val list: List<Product>, val context: Context) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    /* Faz a associação do nosso data class com nosoo ViewHold baseado na posição*/
    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        val product : Product = list[position]
        holder.title.text = product.title
        holder.imageView.setImageResource(R.drawable.camiseta_mockup)  /* por enquantto fixo*/

        /* Adicionar o click, oputExtra é usado para passar os parametros para nossa active
        * oputExtra precisa receber objetos serializeble, por isso precisamo serializar nossos
        * produto e objetos que o compoe, isso é usado pra trafegar entre as activity.
        * após serializar, quando clicar no produto vamos enviar os dados para ProductDetailActivity */

        holder.cardView.setOnClickListener {
            val intent = Intent(context, ProductDetailActivity::class.java)
            intent.putExtra("PRODUCT", product)
            context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        /* Passamos o que será mostrado na tela de layout */
        val imageView: ImageView = itemView.findViewById(R.id.iv_product_image)
        val title: TextView = itemView.findViewById(R.id.tv_product_title)

        val cardView: CardView = itemView.findViewById(R.id.cv_product_item)
    }





}

