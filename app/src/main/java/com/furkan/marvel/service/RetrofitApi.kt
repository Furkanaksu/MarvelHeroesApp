package com.furkan.marvel.service

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query



interface RetrofitApi {
    @GET("characters?")
    fun getCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("limit") limit: String,
        @Query("offset") offset: Int
    ) : Call<String>

}