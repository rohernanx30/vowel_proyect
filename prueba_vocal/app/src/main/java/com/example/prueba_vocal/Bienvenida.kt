package com.example.prueba_vocal

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Bienvenida : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        var usuario:EditText=findViewById<EditText>(R.id.nombre_usuario)
        var btnComenzar: Button = findViewById<Button>(R.id.btn_comenzar)

        btnComenzar.setOnClickListener {

            val nombreUsuario = usuario.text
            if (nombreUsuario.isEmpty()){
                Toast.makeText(this,"Debes de ingresar tu nombre", Toast.LENGTH_SHORT).show()
            }
            else{
            openmenu(nombreUsuario.toString())
        }
    }
}
    private fun openmenu(nombreUsuario:String){
        var intent = Intent(this,Menu::class.java)
        intent.putExtra("nombre_usuario",nombreUsuario)
        startActivity(intent)
    }
}