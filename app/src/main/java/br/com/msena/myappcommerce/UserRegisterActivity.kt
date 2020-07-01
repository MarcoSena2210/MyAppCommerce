package br.com.msena.myappcommerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class UserRegisterActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var textTitle : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_register)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(this.toolbar)

        /* Colocando a seta para voltar, é colocado a ?
           porque esse objeto pode ser null, para funcionar precisa
           subscrever o metodo onSupportNavigateUp   */
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        /* Para não ficar os dois titulos da barra.O da App e o do produto   */
        supportActionBar?.setDisplayShowTitleEnabled(false)

        textTitle = findViewById(R.id.toolbar_title)
        textTitle.text = getString(R.string.user_register_title)

    }

    /* Subscrevendo o metodo para volta ao ser clicado a seta  <-- */
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}