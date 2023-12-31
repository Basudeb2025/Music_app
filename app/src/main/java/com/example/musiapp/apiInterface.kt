package com.example.musiapp

import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface apiInterface {
    @Headers("X-RapidAPI-Key: 8e4301e6f3mshbc16fe000e8c554p1450cejsna74d23590ce2","X-RapidAPI-Host: deezerdevs-deezer.p.rapidapi.com")
    @GET("search")
    fun getData(@Query("q")query: String): retrofit2.Call<allData>
}