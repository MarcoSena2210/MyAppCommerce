package br.com.msena.myappcommerce

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import br.com.msena.myappcommerce.model.Product
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup


class ProductDetailActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var textTitle : TextView
    lateinit var product: Product
    lateinit var productPrice: TextView
    lateinit var productDesc: TextView
    lateinit var chipGroupColor: ChipGroup
    lateinit var chipGroupSize: ChipGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        /* Aqui vamos chamar nossa intent que vai chamar nossa activity  passando a nossa chave
        PRODUCT, rechuperando do nosso ViewHoder
        getSerializableExtra precisa vazer o cast para produto , fazemos isso assim: as Product */
        product = intent.getSerializableExtra("PRODUCT") as Product

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(this.toolbar)

       /* Colocando a seta para voltar, é colocado a ?
          porque esse objeto pode ser null, para funcionar precisa
          subscrever o metodo onSupportNavigateUp   */
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        /* Para não ficar os dois titulos da barra.O da App e o do produto   */
        supportActionBar?.setDisplayShowTitleEnabled(false)

        textTitle = findViewById(R.id.toolbar_title)
        textTitle.text = product.title


        /* Vamos passar as caracteristicas do produto*/
        productPrice = findViewById(R.id.tv_product_price)
        productPrice.text = "R$ ${product.price}"

        productDesc = findViewById(R.id.tv_product_desc)
        productDesc.text = product.description

        chipGroupColor = findViewById(R.id.chip_group_color)
        fillChipColor()

        chipGroupSize = findViewById(R.id.chip_group_size)
        fillChipSize()

    }

    /* Método para fazer o preechmento do do chip Color (as cores)*/
    fun fillChipColor() {
        val colors = product.colors

        for (color in colors) {
            val chip = Chip(ContextThemeWrapper(chipGroupColor.context, R.style.Widget_MaterialComponents_Chip_Choice))
            chip.text = color.name
            chip.isCheckable = true
            chip.chipBackgroundColor = ColorStateList.valueOf(Color.parseColor(color.code))
            chip.chipStrokeWidth = 1.0F
            chip.chipStrokeColor = ColorStateList.valueOf(Color.GRAY)
            chip.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorPrimary)))
            chipGroupColor.addView(chip)
        }
    }

    /* Método para fazer o preechmento do do chip size (tamanho)*/
    fun fillChipSize() {
        val sizes = product.sizes

        for (size in sizes) {
            val chip = Chip(ContextThemeWrapper(chipGroupSize.context, R.style.Widget_MaterialComponents_Chip_Choice))
            chip.text = size.size
            chip.isCheckable = true
            chip.chipBackgroundColor = ColorStateList.valueOf(Color.WHITE)
            chip.chipStrokeWidth = 1.0F
            chip.chipStrokeColor = ColorStateList.valueOf(Color.GRAY)
            chip.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorPrimary)))
            chipGroupSize.addView(chip)
        }
    }


    /* Subscrevendo o metodo para volta ao ser clicado a seta  */
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
