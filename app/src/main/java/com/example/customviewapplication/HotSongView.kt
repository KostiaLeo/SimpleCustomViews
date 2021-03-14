package com.example.customviewapplication

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.example.customviewapplication.databinding.HotSongLayoutBinding

class HotSongView(context: Context, attrsSet: AttributeSet) : ConstraintLayout(context, attrsSet) {
    private val binding =
        HotSongLayoutBinding.bind(inflate(context, R.layout.hot_song_layout, this))

    var songName: String
        get() = binding.songName.text.toString()
        set(value) {
            binding.songName.text = value
        }

    var artistName: String
        get() = binding.artistName.text.toString()
        set(value) {
            binding.artistName.text = value
        }

    init {
        val attrs = context.theme.obtainStyledAttributes(attrsSet, R.styleable.CircleView, 0, 0)

        attrs.getResourceId(R.styleable.HotSongView_image_src, 0).takeUnless { it == 0 }
            ?.let { src ->
                binding.songImage.setImageResource(src)
            }
        attrs.getString(R.styleable.HotSongView_song_name)?.let { songName ->
            binding.songName.text = songName
        }
        attrs.getString(R.styleable.HotSongView_artist_name)?.let { artist ->
            binding.artistName.text = artist
        }

        attrs.recycle()
    }

    fun loadImage(src: String) {
        Glide.with(context)
            .load(src)
            .into(binding.songImage)
    }

    fun loadImage(resId: Int) {
        binding.songImage.setImageResource(resId)
    }

    fun setSong(song: Song) {
        loadImage(song.imageSrc)
        songName = song.name
        artistName = song.artistName
    }
}