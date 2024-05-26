package com.example.prueba_vocal

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import com.example.prueba_vocal.databinding.ActivityVocal5Binding

class vocal5 : AppCompatActivity() {

    var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityVocal5Binding = ActivityVocal5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        mediaPlayer = MediaPlayer.create(this, R.raw.u)

        //agg los binding para moverse
        binding.backA.setOnClickListener {
            open_letrai()
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }
        binding.listen.setOnClickListener {
            mediaPlayer?.start()
        }
        binding.finish.setOnClickListener {
            finish()
        }

    }
    //funciones privadas para mover entre pestañas
    private fun open_letrai(){
        var intent = Intent(this,vocal4::class.java)
        startActivity(intent)
        finish()
    }


    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}