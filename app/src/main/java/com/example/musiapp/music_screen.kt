package com.example.musiapp

import android.animation.ObjectAnimator
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.LinearInterpolator
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.net.toUri
import com.example.musiapp.databinding.ActivityMusicScreenBinding
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class music_screen : AppCompatActivity() {
    lateinit var bind:ActivityMusicScreenBinding
    lateinit var mediaPlayer: MediaPlayer
    var totaltime:Int = 0
    var check : Boolean = true
    var favcheck:Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMusicScreenBinding.inflate(layoutInflater)
        setContentView(bind.root)
        if(supportActionBar != null){
            supportActionBar?.hide()
        }
        //The rotation
        val title: String = intent.getStringExtra("Song_name").toString()
        val song_link:String = intent.getStringExtra("Song_link").toString()
        val pic_link:String = intent.getStringExtra("Pic_link").toString()
        bind.songName.text = title.toString()
        Picasso.get().load(pic_link).into(bind.mImage)
        val rotation = ObjectAnimator.ofFloat(bind.mImage,"rotation",0f,360f)
        rotation.duration = 5000
        rotation.repeatCount = ObjectAnimator.INFINITE
        rotation.interpolator = LinearInterpolator()
        //Mediaplayer
        mediaPlayer = MediaPlayer.create(this,song_link.toUri())
        mediaPlayer .setVolume(1f,1f)
        totaltime = mediaPlayer.duration
        mediaPlayer.start()
        val circle = findViewById<CircleImageView>(R.id.control)
        val text = findViewById<TextView>(R.id.song_name)
        text.isSelected = true
        circle.setImageResource(R.drawable.baseline_pause_24)
        rotation.start()
        bind.fav.setOnClickListener {
            if(favcheck ){
                bind.fav.setImageResource(R.drawable.baseline_favorite_24)
                favcheck = false
            }
            else{
                bind.fav.setImageResource(R.drawable.baseline_favorite_border_24)
                favcheck = true
            }
        }
        bind.backward.setOnClickListener {
            if(mediaPlayer != null){
                val current = mediaPlayer!!.currentPosition
                val newposition = current - 1000
                if(newposition > 0){
                    mediaPlayer.seekTo(newposition)
                    bind.seek.progress =mediaPlayer.currentPosition
                }
                else{
                    mediaPlayer.seekTo(0)
                    bind.seek.progress =mediaPlayer.currentPosition
                }
            }
        }
        bind.forward.setOnClickListener {
            if(mediaPlayer!=null){
                val current = mediaPlayer!!.currentPosition
                val newposition = current + 1000
                if(newposition < totaltime){
                    mediaPlayer.seekTo(newposition)
                    bind.seek.progress =mediaPlayer.currentPosition
                }
                else{
                    mediaPlayer.stop()
                    bind.seek.progress =mediaPlayer.currentPosition
                }
            }
        }
        mediaPlayer.setOnCompletionListener {
            if(mediaPlayer != null){
                mediaPlayer.seekTo(0)
                mediaPlayer.pause()
                circle.setImageResource(R.drawable.baseline_play_arrow_24)
                rotation.pause()
            }
        }
        bind.control.setOnClickListener {
            if(check){
                mediaPlayer.pause()
                rotation.pause()
                circle.setImageResource(R.drawable.baseline_play_arrow_24)
                check = false
            }
            else {
                mediaPlayer.start()
                rotation.start()
                circle.setImageResource(R.drawable.baseline_pause_24)
                check = true
            }
        }
        bind.seek.max = totaltime
        bind.seek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if(p2){
                    mediaPlayer.seekTo(p1)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })
        //
        Handler().postDelayed(object :Runnable{
            override fun run() {
               try {
                   bind.seek.progress =mediaPlayer.currentPosition
                   Handler().postDelayed(this,1000)
               }
               catch(exception:Exception){
                   bind.seek.progress = 0
               }
            }

        },0)
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer.stop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}
