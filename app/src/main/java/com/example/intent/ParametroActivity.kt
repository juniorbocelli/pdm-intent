package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intent.databinding.ActivityParametroBinding

class ParametroActivity : AppCompatActivity() {
    private val apb by lazy {
        ActivityParametroBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(apb.root)
        supportActionBar?.subtitle = "Parâmetro Activity"

        intent.getStringExtra(MainActivity.PARAMETRO_EXTRA)?.apply {
            apb.parametroEt.setText(this)
        }

        apb.enviarParametroBt.setOnClickListener{
            val intentRetorno = Intent()
            intentRetorno.putExtra(MainActivity.PARAMETRO_EXTRA, apb.parametroEt.text.toString())
            setResult(RESULT_OK, intentRetorno)
            finish()
        }
    }
}