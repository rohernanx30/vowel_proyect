package com.example.prueba_vocal

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.prueba_vocal.databinding.ActivityVocal4Binding

class vocal4 : AppCompatActivity() {

    var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityVocal4Binding = ActivityVocal4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        mediaPlayer = MediaPlayer.create(this, R.raw.o)

        //agg los binding para moverse
        binding.backA.setOnClickListener {
            open_letrai()
        }
        binding.nextlettere.setOnClickListener {
            openletteru()
        }
        binding.listen.setOnClickListener {
            mediaPlayer?.start()
        }
    }
    //funciones privadas para mover entre pestañas
    private fun open_letrai(){
        var intent = Intent(this,vocal3::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        finish()
    }
    private fun openletteru(){
        var intent = Intent(this,vocal5::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        finish()
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}