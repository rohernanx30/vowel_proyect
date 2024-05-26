package com.example.prueba_vocal

import android.app.AlertDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.prueba_vocal.databinding.ActivityCuentosBinding

class cuentos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityCuentosBinding = ActivityCuentosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //agg los binding para moverse
        //Cuento elefante
        binding.btnElefante.setOnClickListener {
            cuentoelefante()
        }
        //cuento pulpo
        binding.btnPulpo.setOnClickListener {
            cuentopulpo()
        }
        //Cuento iguana
        binding.btnIguana.setOnClickListener {
            cuentoiguana()
        }
        //salir
        binding.btnSalir.setOnClickListener {
            showExitConfirmationDialog()
        }
    }
    private fun cuentoelefante() {
        var intent = Intent(this,elefante::class.java)
        startActivity(intent)
    }
    private fun cuentoiguana() {
        var intent = Intent(this,iguana::class.java)
        startActivity(intent)
    }
    private fun cuentopulpo() {
        var intent = Intent(this,pulpo::class.java)
        startActivity(intent)
    }
    //funcion privada para pestaña de salir
    private fun showExitConfirmationDialog(){
        // Crea un AlertDialog.Builder y configura el mensaje y los botones
        AlertDialog.Builder(this).apply {
            setTitle("Confirmación de salida")
            setMessage("¿Estás seguro de que quieres salir de la aplicación?")
            setPositiveButton("Aceptar") { dialog, which ->
                // Acción al hacer clic en "Aceptar"
                finishAffinity() // Cierra la aplicación
            }
            setNegativeButton("Cancelar") { dialog, which ->
                // Acción al hacer clic en "Cancelar"
                dialog.dismiss() // Cierra el diálogo
            }
            create()
            show()
        }
    }
}