package com.example.prueba_vocal

import android.app.AlertDialog
import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.prueba_vocal.databinding.ActivityVocal2Binding

class vocal2 : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityVocal2Binding= ActivityVocal2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        mediaPlayer = MediaPlayer.create(this, R.raw.e)
        //agg los binding para moverse
        binding.backA.setOnClickListener {
            open_letraa()
        }
        binding.nextlettere.setOnClickListener {
            openletteri()
        }
        binding.listen.setOnClickListener {
            mediaPlayer?.start()
        }
    }
    //funciones privadas para mover entre pestañas
    private fun open_letraa(){
        var intent = Intent(this,vocal::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        finish()
    }
    private fun openletteri(){
        var intent = Intent(this,vocal3::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        finish()
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}