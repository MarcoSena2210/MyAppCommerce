package br.com.msena.myappcommerce

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.msena.myappcommerce.adapter.ProductAdapter
import br.com.msena.myappcommerce.adapter.ProductCategoryAdapter
import br.com.msena.myappcommerce.model.Product
import br.com.msena.myappcommerce.model.ProductCategory
import br.com.msena.myappcommerce.model.ProductColor
import br.com.msena.myappcommerce.model.ProductSize
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var textTitle: TextView
    lateinit var textLogin: TextView
    /*Categoria*/
    lateinit var recyclerCategory: RecyclerView
    /*Produto*/
    lateinit var recyclerProduct: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        /* Para não ficar os dois titulos da barra.O da App e o do produto   */
        supportActionBar?.setDisplayShowTitleEnabled(false)
        /* Pega o titulo do app da string gravada   */
        textTitle = findViewById(R.id.toolbar_title)
        textTitle.text = getString(R.string.app_name)


        drawerLayout = findViewById(R.id.nav_drawer_layout)

        val toggle: ActionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.toggle_open, R.string.toggle_close)
        drawerLayout.addDrawerListener(toggle)

        toggle.syncState()

        navigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)


        textLogin = navigationView.getHeaderView(0).findViewById(R.id.header_profile_name)
        textLogin.setOnClickListener {
            val intent = Intent(this, UserLoginActivity::class.java)
            startActivity(intent)
        }

        /*Pegar nosso adapter de Categoria*/
        recyclerCategory = findViewById(R.id.rv_main_product_category)

        val arrayCategory = arrayListOf<ProductCategory>(
            ProductCategory("1", "Camisetas"),
            ProductCategory("2", "Calças"),
            ProductCategory("3", "Meias"),
            ProductCategory("4", "Sapatos"),
            ProductCategory("5", "Luvas"),
            ProductCategory("6", "Sandálias"),
            ProductCategory("7", "Cintos")
        )

        val adapterCategory = ProductCategoryAdapter(arrayCategory, this)

        recyclerCategory.adapter = adapterCategory
        recyclerCategory.layoutManager = LinearLayoutManager(this,  LinearLayoutManager.HORIZONTAL, false)
        recyclerProduct = findViewById(R.id.rv_main_product)

        val adapterProduct = ProductAdapter(fillRvProduct(), this)

        recyclerProduct.adapter = adapterProduct
        recyclerProduct.layoutManager = LinearLayoutManager(this,  LinearLayoutManager.HORIZONTAL, false)
    }
    /* Método temporario para cria o produto , que vai retornar uma lista de produtos
    * apenas para preecher, enquanto não busca no banco de dados  */
    fun fillRvProduct(): List<Product> {

        val product1: Product = Product(
            "1",
            "Camiseta 89",
            ProductCategory("id", "Camisetas"),
            "Camiseta super leve para fazer exercicios.",
            19.90,
            arrayListOf(ProductColor("1", "Branco", "#ffffff"),
            ProductColor("2", "Preta", "#000000")),
            arrayListOf(ProductSize("1", "P"),
            ProductSize("1", "M")),
            emptyList())   /* Neste caso passa um array vazio, pois não gravos as imagens no array */

        val product2: Product = Product(
            "1",
            "Calça Jeans",
            ProductCategory("id", "Calças"),
            "Calça impermeavel com proteção de chuva",
            109.00,
            arrayListOf(ProductColor("1", "Branco", "#ffffff"),
            ProductColor("2", "Preta", "#000000")),
            arrayListOf(ProductSize("1", "G"),
            ProductSize("1", "GG")),
            emptyList()) /* Neste caso passa um array vazio, pois não gravos as imagens no array */

        return arrayListOf(product1, product2)
    }


    /* Voltar  */
    override fun onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.nav_home -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_account -> {
                val intent = Intent(this, UserProfileActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_category -> {
                val intent = Intent(this, ProductCategoryActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_orders -> Toast.makeText(this, "Compras", Toast.LENGTH_LONG).show()
            R.id.nav_cart -> Toast.makeText(this, "Carrinho", Toast.LENGTH_LONG).show()
            R.id.nav_logout -> Toast.makeText(this, "Sair", Toast.LENGTH_LONG).show()
        }

        drawerLayout.closeDrawer(GravityCompat.START)

        return true
    }
}