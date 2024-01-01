package com.example.musiapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class song_list : AppCompatActivity() {
    var check:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_list)
        if(supportActionBar != null){
            supportActionBar?.hide()
        }
        val backbtn = findViewById<ImageView>(R.id.backbtn)
        val searchLaout = findViewById<CardView>(R.id.searchLayout)
        val searchbar = findViewById<EditText>(R.id.searchbar)
        val searchbtn = findViewById<ImageView>(R.id.searchbtn)
        val prolay = findViewById<RelativeLayout>(R.id.loadingOverlay)
        val probar = findViewById<ProgressBar>(R.id.loadingProgressBar)

        probar.visibility = View.VISIBLE
        prolay.visibility = View.VISIBLE
        searchLaout.visibility = View.GONE
        searchbtn.setOnClickListener {
            if(check) {
                searchLaout.visibility = View.GONE
                check = false
            }
            else{
                searchLaout.visibility = View.VISIBLE
                check = true
            }
        }
        backbtn.setOnClickListener {
            onBackPressed()
        }
        val retrofiBuilder = Retrofit.Builder()
            .baseUrl("https://collect_the_api_from_rapidApi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(apiInterface::class.java)
        val value:String = intent.getStringExtra("singer").toString()
        val retrofitData = retrofiBuilder.getData(value)
        retrofitData.enqueue(object : Callback<allData?> {
            override fun onResponse(call: Call<allData?>, response: Response<allData?>) {
                if (response.isSuccessful) {
                    val recyclerView = findViewById<RecyclerView>(R.id.recycle)
                    val responseBody = response.body()
                    val array = responseBody?.data!!
                    if (array.isNotEmpty()) {
                        val adaptercreate = adptar(array, this@song_list)
                        probar.visibility = View.GONE
                        prolay.visibility = View.GONE
                        recyclerView.adapter = adaptercreate
                        recyclerView.layoutManager = LinearLayoutManager(this@song_list)
                        adaptercreate.setItemclickListener(object : adptar.onItemclicklitener {
                            override fun onItemclick(position: Int) {
                                val name: String = array[position].title.toString()
                                val pic_link: String = array[position].album.cover.toString()
                                val song: String = array[position].preview.toString()
                                val intent = Intent(this@song_list, music_screen::class.java)
                                intent.putExtra("Song_name", name)
                                intent.putExtra("Song_link", song)
                                intent.putExtra("Pic_link", pic_link)
                                startActivity(intent)
                            }

                        })
                    } else {
                        Toast.makeText(this@song_list, "The array is empty", Toast.LENGTH_SHORT)
                            .show()
                    }
                } else {
                    Toast.makeText(this@song_list, "Failed to load", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<allData?>, t: Throwable) {
                Log.d("TAG: On failure", "Failed" + t.message)
            }
        })
    }
}
