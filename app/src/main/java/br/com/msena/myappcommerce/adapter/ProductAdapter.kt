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
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        /* Passamos o que será mostrado na tela de layout */
        val imageView: ImageView = itemView.findViewById(R.id.iv_product_image)
        val title: TextView = itemView.findViewById(R.id.tv_product_title)
    }





}

