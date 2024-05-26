package com.example.prueba_vocal

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.prueba_vocal.databinding.ActivityVocal3Binding

class vocal3 : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityVocal3Binding = ActivityVocal3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        mediaPlayer = MediaPlayer.create(this, R.raw.i)
        //agg los binding para moverse
        binding.backA.setOnClickListener {
            open_letrae()
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }
        binding.nextlettere.setOnClickListener {
            openlettero()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
        binding.listen.setOnClickListener {
            mediaPlayer?.start()
        }
    }
    //funciones privadas para mover entre pestañas
    private fun open_letrae(){
        var intent = Intent(this,vocal2::class.java)
        startActivity(intent)
        finish()
    }
    private fun openlettero(){
        var intent = Intent(this,vocal4::class.java)
        startActivity(intent)
        finish()
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}