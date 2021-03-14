package com.example.customviewapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.customviewapplication.databinding.SongScreenBinding

class MainActivity : AppCompatActivity() {
    private lateinit var songScreenBinding: SongScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        songScreenBinding = SongScreenBinding.inflate(layoutInflater)
        setContentView(songScreenBinding.root)

        val song = Song("Calling my phone", "Lil Tjay feat. 6LACK", R.drawable.calling_my_phone)
        songScreenBinding.songView.setSong(song)
    }
}