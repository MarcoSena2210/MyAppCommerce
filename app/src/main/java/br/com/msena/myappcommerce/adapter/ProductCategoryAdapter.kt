package br.com.msena.myappcommerce.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.msena.myappcommerce.R
import br.com.msena.myappcommerce.model.ProductCategory


/* Precisa de um ViewHoder que vai representar o nosso layout
do nosso item, só que aqui na nossa classe, precisamos receber uma lista de nossa categorias
 cadastradas e o context que é nossa active,*/
class ProductCategoryAdapter(val list: List<ProductCategory>, val context: Context) : RecyclerView.Adapter<ProductCategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_product_category, parent, false)

        return ViewHolder(view)
    }

    /* Passa a info de quantos itens existe na lista*/
    override fun getItemCount(): Int = list.size

    /* Faz a associação do nosso data class com nosoo ViewHold baseado na posição*/
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category: ProductCategory = list[position]
        holder.title.text = category.title
    }

    /* Cria o View Holder*/
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        /* Passamos o icon e titulo*/
        val icon: ImageView = itemView.findViewById(R.id.iv_category_icon)
        val title: TextView = itemView.findViewById(R.id.tv_category_title)
    }

}