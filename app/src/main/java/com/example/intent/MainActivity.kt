package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    companion object {
        const val PARAMETRO_EXTRA = "PARAMETRO_EXTRA"
        const val PARAMETRO_REQUEST_CODE = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)
        supportActionBar?.subtitle = "Main Activity"

        amb.entrarParametroBt.setOnClickListener {
            val parametroIntent: Intent = Intent(this, ParametroActivity::class.java)
            parametroIntent.putExtra(PARAMETRO_EXTRA, amb.parametroTv.text.toString())
            startActivityForResult(parametroIntent, PARAMETRO_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PARAMETRO_REQUEST_CODE && requestCode == RESULT_OK) {
            val parametroRecebido = data?.let { parametro ->
                amb.parametroTv.text = parametro
            }
    }
}