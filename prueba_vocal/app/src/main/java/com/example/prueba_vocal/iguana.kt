package com.example.prueba_vocal

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.prueba_vocal.databinding.ActivityIguanaBinding

class iguana : AppCompatActivity() {
     var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    var binding: ActivityIguanaBinding = ActivityIguanaBinding.inflate(layoutInflater)
    setContentView(binding.root)

    mediaPlayer = MediaPlayer.create(this, R.raw.cuento_iguana)
    binding.listen.setOnClickListener {
        mediaPlayer?.start()
    }
}
    override fun onDestroy() {
    super.onDestroy()
    mediaPlayer?.release()
    }
}