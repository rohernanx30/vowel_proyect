package com.example.prueba_vocal

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.prueba_vocal.databinding.ActivityVocalBinding

class vocal : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        var binding:ActivityVocalBinding= ActivityVocalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mediaPlayer = MediaPlayer.create(this, R.raw.a)

        //Mover entre entre pantallas
        binding.nextLettere.setOnClickListener {
            siguiente_e()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
        binding.listen.setOnClickListener {
            mediaPlayer?.start()
        }
    }
    //Funciones privadas para cambiar pantallas
    private fun siguiente_e() {
        var intent=Intent(this,vocal2::class.java)
        startActivity(intent)
        finish()
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}